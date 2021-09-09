package com.javarussia.test.java.othertopics.ReflectionAPI;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();

        Class personClass1 = person.getClass();     // это 3 способа получения объекта класса Class
        Class personClass2 = Person.class;
        Class personClass3 = Class.forName("com.javarussia.test.java.othertopics.ReflectionAPI.Person");

        Field[] fields = personClass1.getFields();   //получаем список полей, но не приватных
        System.out.println("getFields:");
        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());   //получилось пусто, потому что поля приватные только у нас
        }

        Field[] declaredFields = personClass1.getDeclaredFields();  // получаем список приватных полей
        System.out.println("\ngetDeclaredFields:");
        for (Field field : declaredFields) {
            System.out.println(field.getName() + ", " + field.getType());
        }

        System.out.println("\ngetMethods:");
        Method[] methods = personClass1.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", " + method.getReturnType() + ", " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("\ngetDeclaredMethods:");
        Method[] declaredMethods = personClass1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + ", " + method.getReturnType() + ", " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("\ngetConstructors:");
        Constructor[] constructors = personClass1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("\ngetAnnotations:");
        Annotation[] annotations = personClass1.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes");
            }
            System.out.println(annotation);
        }
    }

}
