package observer.weather_station;
import java.util.*;

public class WeatherStation extends Observable implements Runnable {
    private float temperature;
    private int maxTemperature = 50;
    private int minTemperature = -30;

    public WeatherStation() {
        this.temperature = generateRandomNumber(getMinTemperature(), getMaxTemperature());
    }
    public void run() {
        while(true) {
            float randomTemperature = generateRandomTemperature() + temperature;
            setTemperature(randomTemperature);
            notifyObservers(temperature);
            try {
                Thread.sleep(generateRandomNumber(1, 3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int generateRandomTemperature() {
        Random random = new Random();
        int[] numbers = {1, 2, -1, -2};
        return numbers[random.nextInt(numbers.length)];
    }

    public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start; // Generates a number between 1 and 5
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        if (temperature > maxTemperature) {
            this.temperature = maxTemperature;
        } else if (temperature < minTemperature) {
            this.temperature = minTemperature;
        } else {
            this.temperature = temperature;
        }
        notifyObservers(this.temperature);
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }
}
