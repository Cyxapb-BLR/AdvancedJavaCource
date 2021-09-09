package com.javarussia.test.java.multithreading.synchronized1;

public class Test2 {
    private int counter;    //общая переменная для нитей

    public static void main(String[] args) throws InterruptedException {
        Test2 test = new Test2();
        test.doWork();
    }

    private synchronized void increment() { // инкремент теперь в синхр методе, т.е.теперь несколько потоков не могут зайти одновременно в этот метод
        counter++;
    }

    public void doWork() throws InterruptedException {
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

        thread1.join(); //текущий поток main останавливается и ждет, пока не отработает поток thread1
        thread2.join();

        // Thread.sleep(6);
        System.out.println(counter); // теперь переменная всегда 20000, потому что инкремент синхронный
    }
}
