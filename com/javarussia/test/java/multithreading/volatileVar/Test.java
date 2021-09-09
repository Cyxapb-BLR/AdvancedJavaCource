package com.javarussia.test.java.multithreading.volatileVar;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner=new Scanner(System.in);
        scanner.nextLine(); //сканер ждет чтобы напечатли любую строкуи нажали энтер

        myThread.shutdown();    //после энтера вызовется шатдаун нити

    }
}

class MyThread extends Thread {
    private volatile boolean running = true; // перемення может быть изменена, она теперь не кэшируется

    @Override
    public void run() {
        int count = 0;
        while (running) {
            System.out.println("Hello " + count++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
