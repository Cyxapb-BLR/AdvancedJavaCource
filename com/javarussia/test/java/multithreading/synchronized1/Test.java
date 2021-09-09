package com.javarussia.test.java.multithreading.synchronized1;

        //  !!! это показана работа без синхронизации !!!

public class Test {

    private int counter;    //общая переменная для нитей

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); //текущий поток main останавливается и ждет, пока не отработает поток thread1
        thread2.join();

        // Thread.sleep(6);
        System.out.println(counter); // получается всегда разное значение, потому что нити могут получить одинаковое
        //значение counter, а потом его будут инкриминировать и записать каждый разное значение в counter
    }
}
