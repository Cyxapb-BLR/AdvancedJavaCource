package com.javarussia.test.java.collections.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test2 {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> people = new ArrayBlockingQueue<Person>(3);
       /* people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1); */       //выдаст исключение,т.к. макс размер очереди =3
        System.out.println(people.offer(person3));
        System.out.println(people.offer(person2));
        System.out.println(people.offer(person4));
        System.out.println(people.offer(person1));      //здесь отработает без ошибки, но 4й элемент в очередь не добавитсяSystem.out.println(people.offer() stem.out.)println(people);

    }
}

