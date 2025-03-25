package observer.weather_station;

import java.util.*;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(float temperature) {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
