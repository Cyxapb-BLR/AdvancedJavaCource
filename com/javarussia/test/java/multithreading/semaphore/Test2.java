package com.javarussia.test.java.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class Test2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        try {
            semaphore.acquire(); //берет одно разрешение у семофора
            semaphore.acquire();
            semaphore.acquire();

            System.out.println("All permits have been acquired");

            semaphore.acquire(); //Здесь поток остановится, т.к. больше нет разрешений

            System.out.println("Can't reach here...");  //сюда не дойдет
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
