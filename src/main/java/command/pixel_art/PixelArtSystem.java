package command.pixel_art;

public class PixelArtSystem {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

    private int[][] pixelArt;

    private int currentX;
    private int currentY;

    public PixelArtSystem() {
        pixelArt = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                pixelArt[i][j] = 0; // Initialize all pixels to 0 (off)
            }
        }
        currentX = 0;
        currentY = 0;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int[][] getPixelArt() {
        return pixelArt;
    }

    public void up() {
        if (currentY > 0) {
            currentY--;
        }
    }

    public void down() {
        if (currentY < HEIGHT - 1) {
            currentY++;
        }
    }

    public void left() {
        if (currentX > 0) {
            currentX--;
        }
    }

    public void right() {
        if (currentX < WIDTH - 1) {
            currentX++;
        }
    }

    public void togglePixel() {
        pixelArt[currentY][currentX] = (pixelArt[currentY][currentX] == 0) ? 1 : 0;
    }

    public void generate() {
        System.out.println("int[][] pixelArt = {");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("    {");
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(pixelArt[i][j]);
                if (j < WIDTH - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (i < HEIGHT - 1) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("};");
    }

}
