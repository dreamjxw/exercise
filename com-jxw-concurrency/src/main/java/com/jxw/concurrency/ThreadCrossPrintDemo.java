package com.jxw.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程交替打印
 */
public class ThreadCrossPrintDemo {

    private static final AtomicInteger flag = new AtomicInteger(0);

    public static void main(String[] args) {
        new ThreadCrossPrintDemo().threadSchedule(10);
    }

    public void threadSchedule(int n) {
        new Thread(() -> print(n, 0, "A")).start();

        new Thread(() -> print(n, 1, "B")).start();

        new Thread(() -> print(n, 2, "C")).start();
    }

    private void print(int n, int i, String mess) {
        for (int j = 0; j < n; j++) {
            while (flag.get() % 3 != i) {
            }
            System.out.print(mess);
            flag.addAndGet(1);
        }
    }
}