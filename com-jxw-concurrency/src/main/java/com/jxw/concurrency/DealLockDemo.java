package com.jxw.concurrency;

/**
 * @author jiaxingwu
 * @date 2020/5/12 21:17
 * @Description 死锁
 */
public class DealLockDemo {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                System.out.println("线程1锁o1");
                try {
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("线程1锁o2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("线程2锁o1");
                synchronized (o1) {
                    System.out.println("线程2锁o2");
                }
            }
        }).start();
    }
}
