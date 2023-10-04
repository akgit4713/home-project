package com.homeproject.homeproject.designs.observer;

public class MobileDisplayObserver implements Observer{
    private final Observable observable;
    private int mobileDisplayTemp;
    public MobileDisplayObserver(Observable observable){
        this.observable = observable;
    }
    @Override
    public void update() {
        mobileDisplayTemp = observable.getData();
    }

    @Override
    public void display() {
        System.out.println("Mobile Display Temperature : " + mobileDisplayTemp);
    }
}
