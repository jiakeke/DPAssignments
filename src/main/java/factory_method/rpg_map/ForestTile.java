package factory_method.rpg_map;

public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "Forest";
    }
}
