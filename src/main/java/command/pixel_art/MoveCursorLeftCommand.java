package command.pixel_art;

public class MoveCursorLeftCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public MoveCursorLeftCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.left();
    }
}
