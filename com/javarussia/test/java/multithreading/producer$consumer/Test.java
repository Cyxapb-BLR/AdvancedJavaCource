package com.javarussia.test.java.multithreading.producer$consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue(10); //создаем очередь на 10 элементов

    public static void main(String[] args) throws InterruptedException {
        //создаем два потока, один будет выполняться для produce(), второй - consumer()
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // потоки постоянно работают, в итоге очередь равна 10 или 9, потому что consumer берет из очереди 10 элемент,
        // очередь становится =9, но producer при этом может успеть положить еще 1 элемент и очередь уже =10.

    }

    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100)); //помещаем в очередь случайное число 0-99
        }
    }

    private static void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take());// берем из очереди число, если random=5
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}
