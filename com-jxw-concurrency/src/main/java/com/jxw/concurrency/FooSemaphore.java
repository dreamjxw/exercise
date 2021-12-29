package com.jxw.concurrency;

import java.util.concurrent.Semaphore;

/**
 * leetcode  https://leetcode-cn.com/problems/print-in-order/
 * <p>
 * 按序打印
 */
class FooSemaphore {

    Semaphore fSemaphore = new Semaphore(1);
    Semaphore sSemaphore = new Semaphore(0);
    Semaphore tSemaphore = new Semaphore(0);
    public FooSemaphore() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        fSemaphore.acquire();
        printFirst.run();
        sSemaphore.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        sSemaphore.acquire();
        printSecond.run();
        tSemaphore.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        tSemaphore.acquire();
        printThird.run();


    }
}