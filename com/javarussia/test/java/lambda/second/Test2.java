package com.javarussia.test.java.lambda.second;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        // map method----------------------------------------------------------------------
        System.out.println("map method:");

        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray();
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr1) + "\n" + list1);

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
        System.out.println(Arrays.toString(arr1));
        arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray();
        System.out.println(Arrays.toString(arr1));

        // filter method----------------------------------------------------------------------
        System.out.println("filter method:");

        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();       // фильтр=элемент делится на 2 без остатка
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // forEach method----------------------------------------------------------------------
        System.out.println("forEach method:");

        Arrays.stream(arr2).forEach(a -> System.out.println(a));        // 1 способ
        list2.stream().forEach(System.out::println);                    // 1 способ

        Arrays.stream(arr2).forEach(System.out::println);               // 2 способ
        list2.stream().forEach(System.out::println);                    // 2 способ

        list2.forEach(System.out::println);                             // 3 способ

        // reduce method----------------------------------------------------------------------
        System.out.println("reduce method:");

        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        int sum = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();// acc - аккумулятор, b - текущий элемент.
        // acc - изначально равен первому элементу, а b начинается браться по очереди начиная со второго элемента.
        // Если мы хотим, чтобы нач. значение acc было другим, то:
        int sum1 = Arrays.stream(arr3).reduce(0, (acc, b) -> acc + b); // изначально acc=0, b=значение самого первого элемента в массиве
        int sum2 = Arrays.stream(arr3).sum();
        int sum3 = Arrays.stream(arr3).reduce(100, (acc, b) -> acc + b);
        int product = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(product);

        // a few methods----------------------------------------------------------------------
        System.out.println("a few methods:");

        int[] arr4 = new int[10];
        List<Integer> list4 = new ArrayList<>();
        fillArr(arr4);
        fillList(list4);

        int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray(); //каждое нечетное число *2
        System.out.println(Arrays.toString(newArray));
        Arrays.stream(arr4).filter(a -> a % 2 != 0).forEach(a -> System.out.println(a * 2));    //каждое нечетное число *2
        list4 = list4.stream().filter(a -> a % 2 != 0).map(a -> a * 2).collect(Collectors.toList());
        System.out.println(list4);

        // ------------------------------------------------------------------------------
        System.out.println("set:");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void fillArr(int[] arr1) {
        for (int i = 0; i < 10; i++) {
            arr1[i] = i + 1;
        }
    }

    private static void fillList(List<Integer> list1) {
        for (int i = 0; i < 10; i++) {
            list1.add(i + 1);
        }
    }
}
