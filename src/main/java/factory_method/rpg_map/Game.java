package factory_method.rpg_map;

public class Game {
    public static void main(String[] args) {
        System.out.println("Creating a 5x5 City map...");
        Map cityMap = createMap("city",5, 5);
        cityMap.display();

        System.out.println("\nCreating a 10x10 Wilderness map...");
        Map wildernessMap = createMap("wilderness", 10, 10);
        wildernessMap.display();
    }

    public static Map createMap(String type, int width, int height) {
        if (type.equals("city")) {
            return new CityMap(width, height);
        } else if (type.equals("wilderness")) {
            return new WildernessMap(width, height);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + type);

        }
    }
}
