package com.jxw.concurrency;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode-cn.com/problems/building-h2o/
 */
class H2O {
    Semaphore hSemaphore = new Semaphore(2);
    Semaphore oSemaphore = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}