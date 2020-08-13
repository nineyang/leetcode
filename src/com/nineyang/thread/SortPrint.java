package com.nineyang.thread;


public class SortPrint {


    private final Object lock = new Object();

    private volatile int count = 1;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            printFirst.run();
            count++;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (count != 2) {
                lock.wait();
            }
            printSecond.run();
            count++;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (count != 3) {
                lock.wait();
            }
            printThird.run();
            count++;
            lock.notifyAll();
        }
    }


}
