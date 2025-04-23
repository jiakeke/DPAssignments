package flyweight.rpg_map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameView extends Application {
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage stage) throws Exception {
        // Create a grid pane to represent the map
        int width = 10;
        int height = 10;
        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        Map cityMap = new CityMap(width, height);
        Map wildernessMap = new WildernessMap(width, height);

        int tileSize = 40;
        int xOffset = 40;
        int yOffset = 10;
        int rowOffset = 20;
        int startY = height*5;

        // Create a 10x10 map with different tile types
        Tile[][] tiles = cityMap.getTiles();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                TileImage tileImage = tiles[i][j].getImage();
                gc.drawImage(tileImage.getImage(), i * xOffset - (j%2)*rowOffset, startY + j * yOffset, tileSize, tileSize);
            }
        }

        startY = height*20;
        tiles = wildernessMap.getTiles();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                TileImage tileImage = tiles[i][j].getImage();
                gc.drawImage(tileImage.getImage(), i * xOffset - (j%2)*rowOffset, startY +j * yOffset, tileSize, tileSize);
            }
        }

        // Set up the scene and stage
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("RPG Map");
        stage.setScene(scene);
        stage.show();
    }
}
