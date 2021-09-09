package com.javarussia.test.java.collections.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        //Queue<Person> people = new LinkedList<>();
        Queue<Person> people = new ArrayBlockingQueue<Person>(10);
        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);
      /*  for (Person person : people) {
            System.out.println(person);
        }*/
        System.out.println(people.remove());        //удаляет первый элемент в очереди
        System.out.println();
        System.out.println(people.peek());          //достает первый элемент из очереди,но не удаляет из нее
        System.out.println(people);
    }
}

