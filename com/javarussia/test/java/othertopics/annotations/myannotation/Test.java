package com.javarussia.test.java.othertopics.annotations.myannotation;

public class Test {
    @MethodInfo(author = "Kate", dateOfCreation = 2021, purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello World");
    }

    @MethodInfo(purpose = "Print Hello World")      //здесь первые 2 поля возьмутся из значений по умолчанию
    public void printDefault() {
        System.out.println("Hello World");
    }

    @MethodInfo(author = "Bob", purpose = "Print Hello World")  //  изменили дефолтное поле author
    public void printModified() {
        System.out.println("Hello World");
    }
}
