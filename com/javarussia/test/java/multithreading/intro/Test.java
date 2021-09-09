package com.javarussia.test.java.multithreading.intro;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        //Thread.sleep(1000);

        MyThread myThread2 = new MyThread();
        myThread2.start();

        System.out.println("I'm going to sleep");
        Thread.sleep(3000);
        System.out.println("I'm awake");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread" + i);
        }
    }
}

