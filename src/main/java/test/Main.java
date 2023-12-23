package test;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        List<String> fruits = Arrays.asList("1","2","3","4","5","6");
        Thread producerThread = new Thread(()->{
            for (String item : fruits) {
                sharedResource.addItem(item);
            }
        });
        Thread consumerThread = new Thread(sharedResource::consumeItem);
        consumerThread.setDaemon(true);

        producerThread.start();
        consumerThread.start();

    }
}
