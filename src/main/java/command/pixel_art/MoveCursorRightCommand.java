package command.pixel_art;

public class MoveCursorRightCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public MoveCursorRightCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.right();
    }

}
