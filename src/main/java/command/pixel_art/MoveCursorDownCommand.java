package command.pixel_art;

public class MoveCursorDownCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public MoveCursorDownCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.down();
    }
}
