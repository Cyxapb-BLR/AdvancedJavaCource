package com.javarussia.test.java.multithreading.callable$future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Runnable
public class Test {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {     // !! через лямбду ниже!!
            //из этого метода невозможно вернуть значение через return, поэтому нужно создавать отдельно поле result
            // и потом в методе в это поле помещать результат.
            // Получается лишний код => анонимный класс new Runnable можно заменить на new Callable,
            // метод call() у которого возвращает значение (См Test2)
            @Override
            public void run() {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                    System.out.println(calculate());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                result++;
            }
        });
        /*executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
                System.out.println(calculate());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
        });*/
        executorService.shutdown();     //запускаем поток

        executorService.awaitTermination(1, TimeUnit.DAYS);     //ждем, чтобы он выполнился

        System.out.println(result);
    }

    private static int calculate() {
        return 5 + 4;
    }
}
