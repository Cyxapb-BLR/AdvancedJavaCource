package com.javarussia.test.java.othertopics.ReflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        // НазваниеКласса1 НазваниеКласса2 названиеМетода
        /*примеры ввода:
        "com.javarussia.test.java.othertopics.ReflectionAPI.Person java.lang.String setName"
        "java.lang.Thread java.lang.String setName"
        */

        Class classObject1 = Class.forName(scanner.next()); // создаем объект Class из первого параметра в строке из консоли
        Class classObject2 = Class.forName(scanner.next()); // 2‑й объект из 2-го параметра
        String methodName = scanner.next();                 // название метода из 3-го параметра

        Method method = classObject1.getMethod(methodName, classObject2);   // метод с данным именем,
        // который принимает параметр classObject2

        Object o1 = classObject1.newInstance();     //создаем объект из объекта класса Class c пом newInstance,
        // используется конструктор по умолчанию

        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");  //создаем объект
        // из объекта класса Class через конструктор, который принимает на вход String
        // и через newInstance устанавливаем ему новое значение для поля String

        method.invoke(o1, o2);  //  запускаем метод через рефлексию с пом метода invoke на объекте o1
        // и в качестве параметра метода передаем o2

        System.out.println(o1);
        System.out.println(o2);
    }
}
