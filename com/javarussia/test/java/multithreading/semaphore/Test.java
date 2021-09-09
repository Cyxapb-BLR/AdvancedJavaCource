package com.javarussia.test.java.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 3 - количество разрешений для потоков,
        // т.е. сколько одновременно потоков может обращаться (пропускная способность)

        try {
            semaphore.acquire(); //Берем одно разрешение. Этот метод будет ждать, если кол-во разрешений =0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release(); //отдаем обратно одно разрешение семофору, когда закончили пользоваться ресурсом
        System.out.println(semaphore.availablePermits());
    }
}
