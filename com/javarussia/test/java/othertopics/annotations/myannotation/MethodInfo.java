package com.javarussia.test.java.othertopics.annotations.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
//  чтобы ограничить использование аннотации, в данном примере аннотация только будет относиться к методам
/*
@Target({ElementType.METHOD, ElementType.TYPE}) // в данном примере аннотация только будет относиться к методам
// и type(либо класс, либо интерфейс, либо перечисления)
*/
@Retention(RetentionPolicy.RUNTIME) //  RUNTIME аннотация видна везде, даже в ходе выполнения программы
public @interface MethodInfo {
    String author() default "Vad";  // + добавили значения по умолчанию для двух полей

    int dateOfCreation() default 2020;

    String purpose();
}
