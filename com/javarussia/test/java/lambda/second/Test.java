package com.javarussia.test.java.lambda.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(Arrays.toString(arr));
        System.out.println(list);

        for (int i = 0; i < 10; i++) {      //умножаем каждый элемент на 2
            arr[i] = arr[i] * 2;
            list.set(i, list.get(i) * 2);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(list);

        arr = Arrays.stream(arr).map(a -> a * 2).toArray();                     //  !!!!!!!!!!!  через лямбда умножаем на 2
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());      //  !!!!!!!!!!!  через лямбда умножаем на 2

        System.out.println(Arrays.toString(arr));
        System.out.println(list);
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
