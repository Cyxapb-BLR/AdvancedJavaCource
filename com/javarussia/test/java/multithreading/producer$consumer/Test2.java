package com.javarussia.test.java.multithreading.producer$consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>(); //очередь не потоко-безопасна,
    // но с пом синхр. блоков и методов wait и notify сделаем потоко-безопасной

    private final int LIMIT = 10; //макс количество элементов в очереди
    private final Object lock = new Object(); //объект на мониторе которого будем вызывать lock

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) { //если очередь равна лимиту, то ставим на паузу поток Producer и отдаем монитор lock, чтобы начал работать Consumer
                    lock.wait();
                }
                System.out.println("put value =" + value);
                queue.offer(value++); //кладем в очередь и икрементируем
                System.out.printf("Queue size is %s\n\n", queue.size());
                lock.notify();  // отдаем монитор Lock, тем самым может запустится Consumer
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) { //если очередь пустая, то ставим на паузу Consumer
                    lock.wait();
                }
                int value = queue.poll();       // берем значение из очереди
                System.out.println("take value =" + value);
                System.out.printf("Queue size is %s\n", queue.size());
                lock.notify(); //оповещаем, отдаем монитор, тем самым может запуститься Producer
            }
            Thread.sleep(1000);
        }
    }
}

