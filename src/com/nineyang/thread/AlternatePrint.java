package com.nineyang.thread;

/**
 * 交替打印
 */
public class AlternatePrint {

    private int n;

    private volatile int count = 0;

    private final Object lock = new Object();

    public AlternatePrint(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (count % 2 == 1) {
                    lock.wait();
                }
                printFoo.run();
                count++;
                lock.notify();
                // printFoo.run() outputs "foo". Do not change or remove this line.}

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                while (count % 2 == 0) {
                    lock.wait();
                }
                printBar.run();
                count++;
                lock.notify();
                // printFoo.run() outputs "foo". Do not change or remove this line.}
            }
        }
    }
}
