package factory_method.rpg_map;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    public Tile createTile() {
        Tile[] types = new Tile[]{new BuildingTile(), new RoadTile(), new ForestTile()};
        int rand = random.nextInt(types.length);
        return types[rand];
    }

}
