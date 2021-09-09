package com.javarussia.test.java.multithreading.callable$future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Callable
public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new Callable<Integer>() {        //через лямбду ниже

            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                    System.out.println(calculate());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return 5;
            }
        });
        executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
                System.out.println(calculate());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            return random.nextInt(10);  //чтобы получить и использовать это значение,
            // нужно использовать интерфейс Future как в Test3
        });


        executorService.shutdown();
    }

    private static int calculate() {
        return 5 + 4;
    }
}
