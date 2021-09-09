package com.javarussia.test.java.multithreading.count$down$latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);  // 3 - столько раз должны вызвать countdown() из потоков(а)

        ExecutorService executorService = Executors.newFixedThreadPool(3); //создаем пул потоков из 3х

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor2(i, countDownLatch)); //добавляем каждому потоку работу
        }
        executorService.shutdown(); //запускаем потоки
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown(); // уменьшаем countdown на единицу
        }
    }
}

class Processor2 implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor2(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await(); //каждый поток спит, пока countdown не станет равен 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread with id %d proceeded\n", id);
    }
}
