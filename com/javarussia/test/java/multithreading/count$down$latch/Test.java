package com.javarussia.test.java.multithreading.count$down$latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); // 3 - кол-во итераций, которые должны отсчитать назад
        // прежде чем защелка отопрется.
        // 3 - столько раз должны вызвать countdown() из потоков(а)


        ExecutorService executorService = Executors.newFixedThreadPool(3); // создаем пул потоков из 3 потоков
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(i, countDownLatch)); //даем каждому потоку работу
        }
        executorService.shutdown(); //запускаем пул потоков
        countDownLatch.await(); // ждет когда защелка откроется, т.е. countdown станет равен 0, после этого запускается дальше текущий поток
        System.out.println("Latch has been opened, main thread is proceeding");
    }
}

class Processor implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
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
        System.out.printf("Thread with id %d proceeded\n", id);

        countDownLatch.countDown(); //уменьшаем на единицу
    }
}
