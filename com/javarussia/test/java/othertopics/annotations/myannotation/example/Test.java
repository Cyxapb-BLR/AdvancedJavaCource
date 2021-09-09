package com.javarussia.test.java.othertopics.annotations.myannotation.example;

import com.javarussia.test.java.othertopics.annotations.myannotation.example.MyAnnotation;

@MyAnnotation
public class Test {
    private String name;

    @MyAnnotation
    public Test() {
    }

    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }
@MyAnnotation
    public static void main(@MyAnnotation String[] args) {

    }
}
