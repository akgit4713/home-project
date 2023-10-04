package com.homeproject.homeproject.designs.observer;

public class TVDisplayObserver implements Observer{
    private final Observable observable;
    private int tvDisplayTemp;
    TVDisplayObserver(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update() {
        tvDisplayTemp = observable.getData();
    }

    @Override
    public void display() {
        System.out.println("TV Display Temperature : " +tvDisplayTemp);
    }

}
