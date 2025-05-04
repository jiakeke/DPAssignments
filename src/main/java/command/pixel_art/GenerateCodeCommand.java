package command.pixel_art;

public class GenerateCodeCommand implements Command {
    private PixelArtSystem pixelArtSystem;

    public GenerateCodeCommand(PixelArtSystem pixelArtSystem) {
        this.pixelArtSystem = pixelArtSystem;
    }

    @Override
    public void execute() {
        pixelArtSystem.generate();
    }
}
