package flyweight.rpg_map;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Tile[] types = new Tile[]{new Tile(TileType.WATER), new Tile(TileType.SWAMP), new Tile(TileType.FOREST)};
        int rand = random.nextInt(types.length);
        return types[rand];
    }
}
