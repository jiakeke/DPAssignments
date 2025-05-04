package command.pixel_art;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create the PixelArtSystem
        PixelArtSystem pixelArtSystem = new PixelArtSystem();

        // Create the Pixel Art Editor Grid Panel

        VBox layout = new VBox();
        // Add the grid to the layout
        GridPane grid = new GridPane();

        for (int i=0; i < pixelArtSystem.getHeight(); i++) {
            for (int j=0; j < pixelArtSystem.getWidth(); j++) {
                // Create a rectangle for each pixel
                int value = pixelArtSystem.getPixelArt()[i][j];
                Rectangle pixelRect = new Rectangle(70, 70);
                if (value == 1) {
                    pixelRect.setFill(Color.BLUE);
                } else {
                    pixelRect.setFill(Color.YELLOW);
                }

                if (i == pixelArtSystem.getCurrentY() && j == pixelArtSystem.getCurrentX()) {
                    // Highlight the current pixel
                    pixelRect.setStroke(Color.RED);
                } else {
                    // Set the stroke to yellow for other pixels
                    pixelRect.setStroke(Color.WHITE);
                }

                grid.add(pixelRect, j, i);
            }
        }

        Button generateButton = new Button("Generate Code");

        layout.getChildren().addAll(grid, generateButton);

        generateButton.setFocusTraversable(false);

        Scene scene = new Scene(layout, 600, 800);

        // Set up the stage
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();

        // Set up the commands
        Command moveUp = new MoveCursorUpCommand(pixelArtSystem);
        Command moveDown = new MoveCursorDownCommand(pixelArtSystem);
        Command moveLeft = new MoveCursorLeftCommand(pixelArtSystem);
        Command moveRight = new MoveCursorRightCommand(pixelArtSystem);
        Command togglePixel = new TogglePixelCommand(pixelArtSystem);
        Command generate = new GenerateCodeCommand(pixelArtSystem);
        // Set up the key event handlers
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    moveUp.execute();
                    break;
                case DOWN:
                    moveDown.execute();
                    break;
                case LEFT:
                    moveLeft.execute();
                    break;
                case RIGHT:
                    moveRight.execute();
                    break;
                case SPACE:
                    togglePixel.execute();
                    break;
            }
            System.out.println("Current Position: (" + pixelArtSystem.getCurrentX() + ", " + pixelArtSystem.getCurrentY() + ")");
            // Update the grid after each command
            for (int i=0; i < pixelArtSystem.getHeight(); i++) {
                for (int j=0; j < pixelArtSystem.getWidth(); j++) {
                    Rectangle pixelRect = (Rectangle) grid.getChildren().get(j * pixelArtSystem.getWidth() + i);
                    int value = pixelArtSystem.getPixelArt()[j][i];
                    if (value == 1) {
                        pixelRect.setFill(Color.BLUE);
                    } else {
                        pixelRect.setFill(Color.YELLOW);
                    }

                    if (i == pixelArtSystem.getCurrentX() && j == pixelArtSystem.getCurrentY()) {
                        // Highlight the current pixel
                        pixelRect.setStroke(Color.RED);
                    } else {
                        // Set the stroke to yellow for other pixels
                        pixelRect.setStroke(Color.WHITE);
                    }
                }
            }
        });

        // Set up the button action
        generateButton.setOnAction(event -> {
            generate.execute();
        });

    }
}