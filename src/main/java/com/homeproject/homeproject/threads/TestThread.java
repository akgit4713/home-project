package com.homeproject.homeproject.threads;

public class TestThread {
    private static final int MAX_NUM = 100;
    private static int currentNum = 1;

    public static void main(String[] args) {
        Object lock = new Object();

        for (int i = 0; i < MAX_NUM; i++) {
            final int threadNum = i + 1;
            new Thread(() -> {
                synchronized (lock) {
                    while (currentNum != threadNum) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(threadNum + " " + Thread.currentThread().getName());
                    currentNum++;
                    lock.notifyAll();
                }
            }).start();
        }
    }
}
