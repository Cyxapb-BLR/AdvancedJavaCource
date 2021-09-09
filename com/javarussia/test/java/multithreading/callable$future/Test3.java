package com.javarussia.test.java.multithreading.callable$future;

import java.util.Random;
import java.util.concurrent.*;

// Future and Callable
public class Test3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> { //Callable через лямбду
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            return random.nextInt(10);
        });
        executorService.shutdown();

        // executorService.awaitTermination(1, TimeUnit.DAYS);

        int result = future.get();      // get дожидается окончания выполнения потока
        System.out.println(result);
        // System.out.println(future.get(1, TimeUnit.DAYS)); // можно заменить на это
    }
}
