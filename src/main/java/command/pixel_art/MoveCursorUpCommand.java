package command.pixel_art;

public class MoveCursorUpCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public MoveCursorUpCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.up();
    }
}
