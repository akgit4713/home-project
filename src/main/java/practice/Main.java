package practice;


import java.util.ArrayList;
import java.util.List;

public class Main {


    static class Person{
        public String name;

        Person(String name){
            this.name = name;
        }

        public synchronized void task1(Person person){
            System.out.println("Task done by " +person.name);
            person.task2();
        }
        public synchronized void task2(){
            System.out.println("Task done back by " +this.name);
        }
    }



    static class LRUModified{
        int capacity;
        List<String> cache = new ArrayList<>();

        public void set(String value){

            /**
             * if cache size is equal to capacity
             *
             */
            synchronized (LRUModified.class) {
                while (cache.size() == capacity) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                cache.add(value);
                notifyAll();
            }
        }

        public void invalidate(){
            /**
             *
             * invalidation using LRU logic
             */
            notify();
        }

        public String get(Integer key){

            /**
             *
             * Fetch and return
             * LRU
             */

            synchronized (LRUModified.class) {
                /**
                 * update linked list
                 * update hashmap
                 */
                notifyAll();
            }
            return cache.get(key);
        }


    }

    public static void main(String[] args) {
        Person p1 = new Person("A");
        Person p2 = new Person("B");

        Thread t1 = new Thread(()->{p1.task1(p2);});
        Thread t2 = new Thread(()->{p2.task1(p1);});

        t1.start();
        t2.start();

    }
}
