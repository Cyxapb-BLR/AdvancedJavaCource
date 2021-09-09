package com.javarussia.test.java.regularexpessions.pattern$matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "Hello, Guys! U send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks,Joe! That's cool. I'm sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";
        Pattern email = Pattern.compile("\\w+@(gmail|yandex)\\.(com|ru)");   //регуляркой описываем email шаблон
        Matcher matcher = email.matcher(text);  // создаем matcher для email шаблона и вставляем исх текст, с которым будем работать
        while (matcher.find()) {        // ищем в тексте фрагменты, которые соответствуют email
            System.out.println(matcher.group());    // выводим найденный элемент в тексте
        }
        System.out.println("--------------------------------");

        // если хотим вывести результат по группам:
        email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");    // каждую группу поместил в ()
        matcher = email.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group() + ":");
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3) + "\n");
        }
    }
}
