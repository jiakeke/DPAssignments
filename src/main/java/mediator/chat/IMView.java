package mediator.chat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IMView extends Application {
    MessageCenter messageCenter = new MessageCenter();

    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] users = new String[]{"Gary", "Mike", "Jacky"};
        for (String user : users) {
            Controller controller = new Controller(user, users, messageCenter);
            runIM(controller);
            messageCenter.register(controller);
        }
    }

    public Stage runIM(Controller controller) {
        // Initialize the IMController with the given username

        // Initialize the main application window
        Stage stage = new Stage();
        stage.setTitle("Chat for: " + controller.getUsername());
        stage.setWidth(800);
        stage.setHeight(600);

        // Set up the scene and show the stage
        StackPane root =  new StackPane();
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        Label label = new Label("Messages");
        ListView<String> messages = new ListView<>();
        controller.setMessages(messages);

        Label sendToLabel = new Label("Send To: ");
        ChoiceBox<String> sendTo = new ChoiceBox<>();
        sendTo.getItems().addAll(controller.getUsers());
        sendTo.setValue((String) controller.getUsers().get(0));

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here...");
        messageField.setPrefWidth(300);
        Button sendButton = new Button("Send");

        HBox sendToBox = new HBox();
        sendToBox.setSpacing(10);
        sendToBox.getChildren().addAll(sendToLabel, sendTo, messageField, sendButton);

        vbox.getChildren().addAll(label, messages, sendToBox);
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

        // Set up the send button action to controller.sendMessage
        sendButton.setOnAction(event -> {
            String message = messageField.getText();
            String recipient = sendTo.getValue();
            if (!message.isEmpty()) {
                controller.sendMessage(message, recipient);
                messageField.clear();
            }
        });

        return stage;
    }

}
