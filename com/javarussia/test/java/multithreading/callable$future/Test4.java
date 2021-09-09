package com.javarussia.test.java.multithreading.callable$future;

import java.util.Random;
import java.util.concurrent.*;

// с пом Future and Callable можно бросать исключения и ловить их в потоке
public class Test4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> { //Callable через лямбду
            System.out.println("Starting");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt();
            if (randomValue < 5) {
                throw new Exception("Something bad happened"); //бросаем исключение
            }
            return random.nextInt(10);
        });
        executorService.shutdown();

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {            //  ловим исключение из потока
            Throwable cause = e.getCause();         //  получаем исключение
            System.out.println(cause.getMessage()); // пишем сообщение исключения
            // e.printStackTrace();
        }
        // System.out.println(future.get(1, TimeUnit.DAYS));
    }
}