package com.siiruo.bytecode.modification;

/**
 * Created by siiruo wong on 2020/1/9.
 */
public class TestInterrupt {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            for (;;){
                System.out.println("***************************HHHHHHHHH*******");
//                try {
//                   // Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().isInterrupted());
            }
        },"wang-thread");

        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
