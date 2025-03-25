package observer.weather_station;

public class Main {
    public static void main(String[] args) {
        WeatherStation myStation = new WeatherStation();

        WeatherObserver observer1 = new WeatherObserver();
        WeatherObserver observer2 = new WeatherObserver();
        WeatherObserver observer3 = new WeatherObserver();

        myStation.addObserver(observer1);
        myStation.addObserver(observer2);
        myStation.addObserver(observer3);

        Thread thread = new Thread(myStation);

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myStation.removeObserver(observer2);
    }
}
