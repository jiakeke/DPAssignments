package flyweight.rpg_map;

import java.util.EnumMap;
import java.util.Map;

public class TileImageFactory {
    private static final Map<TileType, TileImage> images = new EnumMap<>(TileType.class);

    public static TileImage getTileImage(TileType type) {
        TileImage tileImage = images.get(type);
        if (tileImage == null) {
            tileImage = new TileImage(type.getImagePath());
            images.put(type, tileImage);
            System.out.println("Missing image for " + type + " from " + type.getImagePath());
        }
        return tileImage;
    }
}
