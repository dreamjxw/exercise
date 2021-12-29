package com.jxw.concurrency;

/**
 * @author jiaxingwu
 * @date 2020/12/16 15:55
 * @description 生产消费者模型
 */
public class ProduceAndConsumeDemo {
    private static final Integer MAX_NUMBER = 100;
    private static final Integer MIN_NUMBER = 10;
    private static Integer PRODUCT_NUMBER = 0;


    public static void main(String[] args) {
        ProduceAndConsumeDemo test = new ProduceAndConsumeDemo();
        new Thread(test::pro).start();
        new Thread(test::con).start();
    }


    private void pro() {
        while (true) {
            product();
        }
    }

    private void con() {
        while (true) {
            consumer();
        }
    }


    private synchronized void product() {
        if (PRODUCT_NUMBER < MAX_NUMBER) {
            PRODUCT_NUMBER++;
            System.out.println("生产第" + PRODUCT_NUMBER + "件商品");
            notifyAll();
            return;
        }
        System.out.println("商品已爆仓~~");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void consumer() {
        if (PRODUCT_NUMBER >= MIN_NUMBER) {
            System.out.println("消费第" + PRODUCT_NUMBER + "件商品");
            PRODUCT_NUMBER--;
            notifyAll();
            return;
        }
        System.out.println("商品无货~~");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
