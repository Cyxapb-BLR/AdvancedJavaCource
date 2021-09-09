package com.javarussia.test.java.multithreading.synchronized1;

public class Test3 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Test3 test3 = new Test3();
        test3.doWork();
    }


    public void increment() {
        synchronized (this) {   // Здесь делаем синхр блок, а не весь синхр метод, в итоге сейчас это эквивалентно Test2
            counter++;
        }
    }

    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
