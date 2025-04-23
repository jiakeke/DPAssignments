package flyweight.rpg_map;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Tile[] types = new Tile[]{new Tile(TileType.BUILDING), new Tile(TileType.ROAD), new Tile(TileType.FOREST)};
        int rand = random.nextInt(types.length);
        return types[rand];
    }

}
