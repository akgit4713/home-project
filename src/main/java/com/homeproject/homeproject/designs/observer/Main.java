package com.homeproject.homeproject.designs.observer;

public class Main {
    public static void main(String[] args) {
        Observable observable = new WeatherStationObservable();
        Observer observer1 = new TVDisplayObserver(observable);
        Observer observer2 = new MobileDisplayObserver(observable);
        observable.add(observer1);
        observable.add(observer2);
        observable.setData(23);
        observable.notifyObservers();
    }
}
