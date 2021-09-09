package com.javarussia.test.java.lambda.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("GoodBye");
        list.add("a");
        list.add("ab");

        System.out.println(list);

      /*  list.sort((o1, o2) -> {               //заменим на лямбду
            if (o1.length() > o2.length())
                return 1;
            if (o1.length() < o2.length())
                return -1;
            return 0;
        });*/

        list.sort((s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            if (s1.length() < s2.length()) return -1;
            return 0;
        });
        System.out.println(list);

        list.add("fghj");
        list.add("asd");
        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length())); //еще короче форма записи

        System.out.println(list);

        list.add("fagfagard");
        list.add("dggzagr");

        Comparator<String> comparator = (s1, s2) -> {       //можно блок лямбды присвоить компаратору
            if (s1.length() > s2.length()) return 1;
            if (s1.length() < s2.length()) return -1;
            return 0;
        };
        list.sort(comparator);
        System.out.println(list);
    }
}
