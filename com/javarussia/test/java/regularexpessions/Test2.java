package com.javarussia.test.java.regularexpessions;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        // split method-----------------------------------------------------------
        String a = "Hello there hey";
        String[] words = a.split(" ");  // разделяем строку по пробелам и слова добавляем в массив
        System.out.println(Arrays.toString(words));

        a = "Hello.there.hey";
        String[] words1 = a.split("\\.");       // по точкам
        System.out.println(Arrays.toString(words1));

        a = "Hello156484846there89562262hey";
        String[] words3 = a.split("\\d+");      // по цифрам
        System.out.println(Arrays.toString(words3));

        // replace method---------------------------------------------------------
        String b = "Hello there hey";
        b = b.replace(" ", ".");  // меняем пробел на точку
        System.out.println(b);

        b = "Hello15641195there4645251hey";
        b = b.replace("\\d+", "-");     // цифры не заменились, нужно использовать replaceAll
        System.out.println(b);

        // replaceAll-------------------------------------------------------------
        b = b.replaceAll("\\d+", "-");  // теперь работает
        System.out.println(b);

        // replaceFirst
        b = "Hello15641195there4645251hey";
        b = b.replaceFirst("\\d+", " ");    // заменили первый блок цифр
        System.out.println(b);
    }
}
