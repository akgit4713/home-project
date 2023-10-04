package com.homeproject.homeproject.designs.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservable implements Observable {
    private final List<Observer> observerList = new ArrayList<>();
    public int temp = 20;

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observerList){
            observer.update();
            observer.display();
        }
    }

    @Override
    public void setData(int data) {
        temp = data;
    }

    @Override
    public int getData() {
        return temp;
    }
}
