package com.javarussia.test.java.multithreading.interruption;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1000_000_000; i++) {
                   /* try {         //блок делает такую же работу как и блок if
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                        break;
                    }*/
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("\nThread was interrupted\n");
                        break;
                    }
                    double sin = Math.sin(random.nextDouble());
                    System.out.println(i + " : " + sin);
                }
            }
        });
        System.out.println("Starting thread");

        thread.start();

        Thread.sleep(1000);
        thread.interrupt(); // interrupt Должен обязательно вызываться до join, иначе мы до него не дойдем

        thread.join();

        System.out.println("Thread has finished");
    }
}
