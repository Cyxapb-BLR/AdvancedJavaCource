package com.javarussia.test.java.multithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  //создаем пул потоков

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));    //создает работы для пула потоков
        }
        executorService.shutdown();     // работает почти как старт для потока, подтверждает создание всех работ
        System.out.println("All tasks submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS);// указываем время сколько ждать,
        // чтобы потоки выполнили задание, main спит, пока не выполняться инструкции

        System.out.println("All tasks completed");
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Work %d was completed\n", id);
    }
}
