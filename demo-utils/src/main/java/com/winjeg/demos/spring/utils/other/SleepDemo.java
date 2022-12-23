package com.winjeg.demos.spring.utils.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author winjeg
 */
public class SleepDemo {

    private final static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
                // 此处的sleep与不sleep会导致线程执行过程不一样
                // sleep相当于设置了安全点，main 线程会继续执行不受此线程影响
                // 主要是因为 int 是可数循环，如果换成long 这里就不用sleep了
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "执行结束!");
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
