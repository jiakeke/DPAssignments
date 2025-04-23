package flyweight.rpg_map;

public enum TileType {
    BUILDING,
    FOREST,
    ROAD,
    WATER,
    SWAMP;

    public String getImagePath() {
        return this.name().toLowerCase() + ".gif";
    }
    }
