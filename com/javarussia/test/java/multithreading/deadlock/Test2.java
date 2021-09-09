package com.javarussia.test.java.multithreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Runner2 runner = new Runner2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner2 {
    private Account2 account1 = new Account2();
    private Account2 account2 = new Account2();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                Account2.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();  // unlock нужно обязательно делать в finally блоке
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock2.lock();
            lock1.lock();         /* если написать так, то будет deadlock,
            т.к. 1 поток может поставить лок на lock1, а 2 - на lock2.
             Но если нужно сделать, чтобы локи брались именно в таком порядке, то см Test3*/

            //а так работать будет, потому что локи ставятся в правильном порядке:
            /*lock1.lock(); //а так работать будет, потому что локи ставятся в правильном порядке
            lock2.lock();*/

            try {
                Account2.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account2 {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void woithdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account2 acc1, Account2 acc2, int amount) {
        acc1.woithdraw(amount);
        acc2.deposit(amount);
    }
}

