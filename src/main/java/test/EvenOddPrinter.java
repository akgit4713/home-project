package test;

public class EvenOddPrinter {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread evenThread = new Thread(numberPrinter);
        Thread oddThread = new Thread(numberPrinter);

        evenThread.start();
        oddThread.start();
    }
}

class NumberPrinter implements Runnable {
    private int number = 1;
    private final Object lock = new Object();

    @Override
    public void run() {
        while (number <= 20) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
