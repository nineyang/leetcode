package com.nineyang.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrintReentrantLock {

    private int n;

    private volatile int count = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition first = lock.newCondition();
    private final Condition second = lock.newCondition();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (count % 2 == 1) {
                    first.await();
                }
                printFoo.run();
                count++;
                second.signal();

            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            lock.lock();
            while (count % 2 == 0) {
                second.await();
            }
            printBar.run();
            count++;
            first.signal();

        } finally {
            lock.unlock();
        }
    }
}
