package flyweight.rpg_map;

public class Tile {
    TileImage image;
    TileType type;

    public Tile(TileType type) {
        this.type = type;
        this.image = TileImageFactory.getTileImage(type);
    }

    public TileImage getImage() {
        return image;
    }
}
