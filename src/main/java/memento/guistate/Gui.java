package memento.guistate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    ListView<IMemento> historyListView = new ListView<>();

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 19);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label undoLabel = new Label("Press Ctrl-Z to undo the last change.");
        undoLabel.setPadding(insets);

        Label redoLabel = new Label("Press Ctrl-Y to redo the last undone.");
        redoLabel.setPadding(insets);

        Button historyButton = new Button("Histories");
        historyButton.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, undoLabel, redoLabel, historyButton);

        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        // set action for history button
        historyButton.setOnAction(event -> {
            historyListView.getItems().addAll(controller.getHistory());
            historyListView.setOnMouseClicked(e -> {
                IMemento selectedMemento = historyListView.getSelectionModel().getSelectedItem();
                if (selectedMemento != null) {
                    controller.restoreState(selectedMemento);
                    updateGui();
                }
            });
            historyListView.setPrefSize(200, 300);
            historyListView.setPadding(insets);
            Scene historyScene = new Scene(historyListView);
            Stage historyStage = new Stage();
            historyStage.setWidth(300);
            historyStage.setHeight(400);
            historyStage.setScene(historyScene);
            double ownerX = stage.getX();
            double ownerY = stage.getY();
            double ownerWidth = stage.getWidth();
            historyStage.setX(ownerX + ownerWidth);
            historyStage.setY(ownerY);
            historyStage.setTitle("Histories");
            historyStage.show();
        });


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void updateHistoryListView() {
        // called after restoring state from a Memento
        historyListView.getItems().clear();
        historyListView.getItems().addAll(controller.getHistory());
    }
}
