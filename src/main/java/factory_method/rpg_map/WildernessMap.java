package factory_method.rpg_map;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Tile[] types = new Tile[]{new ForestTile(), new SwampTile(), new WaterTile()};
        int rand = random.nextInt(types.length);
        return types[rand];
    }
}
