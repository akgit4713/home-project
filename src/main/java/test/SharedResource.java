package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SharedResource {
    private final Queue<String> itemList;
    private int capacity;

    public SharedResource(int capacity){
        this.capacity = capacity;
        this.itemList = new LinkedList<>();
    }

    public synchronized void addItem(String item){

            while (itemList.size() == capacity){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting since size full!");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            itemList.offer(item);
            System.out.println(Thread.currentThread().getName() + " added item : " + item);
            notify();

    }

    public void consumeItem(){
        synchronized (this) {
            while (itemList.isEmpty()){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting since size empty!");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!itemList.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " is removing the item : " + itemList.poll());
                notify();
                consumeItem();
            }
        }
    }

}
