package com.jxw.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 */
class FizzBuzz {
    Semaphore semaphore3 = new Semaphore(0);
    Semaphore semaphore5 = new Semaphore(0);
    Semaphore semaphore3A5 = new Semaphore(0);
    Semaphore semaphoreN = new Semaphore(1);
    private final int n;

    public FizzBuzz(int n) {
        this.n = n;
    }


    // printFizz.run() outputs "fizz".   3
    public void fizz(Runnable printFizz) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                semaphore3.acquire();
                printFizz.run();
                semaphoreN.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".  5
    public void buzz(Runnable printBuzz) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                semaphore5.acquire();
                printBuzz.run();
                semaphoreN.release();
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".  3 and 5
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {


        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                semaphore3A5.acquire();
                printFizzBuzz.run();
                semaphoreN.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.   not 3 and 5
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreN.acquire();

            if (i % 3 == 0 && i % 5 == 0) {
                semaphore3A5.release();
                continue;
            }
            if (i % 3 == 0 && i % 5 != 0) {
                semaphore3.release();
                continue;
            }
            if (i % 3 != 0 && i % 5 == 0) {
                semaphore5.release();
                continue;
            }

            printNumber.accept(i);
            semaphoreN.release();
        }
    }
}