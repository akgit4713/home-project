package com.homeproject.homeproject.threads;

public class TestThread {
    private static final int MAX_NUM = 100;
    private static volatile int currentNum = 1;

    public static void main(String[] args) {
        Object lock = new Object();

        for (int i = 0; i < MAX_NUM; i++) {
            final int threadNum = i + 1;
            new Thread(() -> {
                System.out.println("starting thread " + threadNum);
                synchronized (lock) {
                    System.out.println("lock aquired by " + threadNum);
                    while (currentNum != threadNum) {
                        try {
                            System.out.println("thread is waiting " + threadNum);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(threadNum + " " + Thread.currentThread().getName());
                    currentNum++;
                    lock.notify();
                }
            }).start();
        }
    }
}
