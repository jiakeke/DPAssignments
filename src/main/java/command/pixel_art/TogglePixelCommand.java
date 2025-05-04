package command.pixel_art;

public class TogglePixelCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public TogglePixelCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.togglePixel();
    }
}
