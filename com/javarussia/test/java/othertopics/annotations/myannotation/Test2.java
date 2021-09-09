package com.javarussia.test.java.othertopics.annotations.myannotation;

//@MethodInfo(purpose = "print hello world")      // здесь используем аннотацию для класса, будет ошибка так установили ограничение target только для методов
public class Test2 {
    @MethodInfo(purpose = "print hello world")
    public void printHelloWorld() {
        System.out.println("Hello World");
    }
}
