package com.javarussia.test.java.multithreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Runner3 runner = new Runner3();
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

class Runner3 {
    private Account3 account1 = new Account3();
    private Account3 account2 = new Account3();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();       // пытаемся взять оба лока
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    System.out.println("Took 2 locks");
                    return;
                }
                if (firstLockTaken) {
                    lock1.unlock();
                    System.out.println("----------------lock1 unlocked----------------");
                }
                if (secondLockTaken) {
                    lock2.unlock();
                    System.out.println("----------------lock2 unlocked----------------");
                }
            }
            try {
                Thread.sleep(1);  //  работа кода заметнее при значении 0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);

            try {
                Account3.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();  // unlock нужно обязательно делать в finally блоке
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);

            try {
                Account3.transfer(account2, account1, random.nextInt(100));
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

class Account3 {
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

    public static void transfer(Account3 acc1, Account3 acc2, int amount) {
        acc1.woithdraw(amount);
        acc2.deposit(amount);
    }
}