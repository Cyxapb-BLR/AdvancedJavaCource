package com.javarussia.test.java.collections.iterable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int idx = 0;
        //before java 5
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (idx == 1) {
                iterator.remove();      //итератор может удалять текущий элемент
            }
            idx++;
        }
        System.out.println();
        System.out.println(list);

        //java 5
        /*for (Integer integer : list) {
            //list.remove(1);   // в цикле foreach нельзя удалять элементы, потому что в след цикле будет ошибка
            System.out.println(integer);
        }*/
    }
}
