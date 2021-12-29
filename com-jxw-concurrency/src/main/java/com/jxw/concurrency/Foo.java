package com.jxw.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode  https://leetcode-cn.com/problems/print-in-order/
 * <p>
 * 按序打印
 */
class Foo {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            if (atomicInteger.get() % 3 == 0) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                atomicInteger.getAndIncrement();
                return;
            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (atomicInteger.get() % 3 == 1) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printSecond.run();
                atomicInteger.getAndIncrement();
                return;
            }

        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (atomicInteger.get() % 3 == 2) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printThird.run();
                atomicInteger.getAndIncrement();
                return;
            }
        }

    }
}