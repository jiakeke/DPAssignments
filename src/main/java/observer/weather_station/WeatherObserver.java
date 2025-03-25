package observer.weather_station;

public class WeatherObserver implements Observer {
    private int id;
    private static int counter = 1;

    public WeatherObserver() {
        this.id = counter++;
    }

    @Override
    public void update(float temperature) {
        System.out.printf("Weather observer %d received an update: Current temperature is %.2f\n", this.id, temperature);
    }
}
