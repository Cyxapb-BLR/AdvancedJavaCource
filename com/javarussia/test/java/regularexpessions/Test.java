package com.javarussia.test.java.regularexpessions;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        String a = "1234";
        System.out.println(a.matches("1234"));      //сравнение строк = true
        System.out.println(a.matches("1235"));      //сравнение строк = false

        a = "Hello";
        System.out.println(a.matches("Hello"));     //выдает true, если строки полностью совпадают

        // ---------- На этом сайте все об регулярных выражениях: ----------------
        new URL("https://www.regexlib.com/CheatSheet.aspx");
        /*
         \\d - Одна цифра
         \\w - Одна англ буква
         \\w = [a-zA-Z]
         + - 1 или более чисел
         * - 0 или более чисел
         ? - 0 или 1 символов до, т.е. может быть либо нет
         (x|y|z) - одна строка из множества строк
         [abc] = (a|b|c) и так далее
         [a-zA-Z] - все англ буквы
         [0-9] - \\d
         [^abc] - отрицание, все символы кроме [abc]

         . - любой символ
         точное количество предыдущих символов:
         {2} -  2 цифры до - (\\d{2})
         {2, } - 2 или более символа, (\\d{2,}) - от 2 до бесконечности цифры
         {2,4} - 2-4 символа, (\\d{2,4}) - 2-4 wbahs
        * */

        a = "d";
        System.out.println(a.matches("d"));
        System.out.println(a.matches("\\d"));       //  false, потому что нет цифры в строке

        a = "1";     // =9 или любая другая цифра
        System.out.println(a.matches("\\d"));       // теперь true

        a = "91";
        System.out.println(a.matches("\\d"));       //  false, потому что теперь не одна цифра

        System.out.println(a.matches("\\d+"));      //  true, больше 1 цифры

        a = "";
        System.out.println(a.matches("\\d+"));      //  false, нет цифр
        a = "1";
        System.out.println(a.matches("\\d+"));      //  true

        System.out.println(a.matches("\\d*"));      //  true - цифр 0 или более

        a = "1561661561616";
        System.out.println(a.matches("\\d*"));      //  true

        a = "";
        System.out.println(a.matches("\\d*"));      //  true

        a = "-1651";
        System.out.println(a.matches("\\d*"));      //  false - не описан минус, не только цифры 0 или более
        System.out.println(a.matches("-\\d*"));     //  теперь true

        String b = "16556161";
        String c = "+12124";
        System.out.println(a.matches("-?\\d*"));    //  true - минус может быть, а может и не быть
        System.out.println(b.matches("-?\\d*"));    //  true - минус может быть, а может и не быть
        System.out.println(c.matches("-?\\d*"));    //  false - плюс не может быть перед числом

        System.out.println(a.matches("\\+?-?\\d*"));    //true
        System.out.println(b.matches("\\+?-?\\d*"));    //true
        System.out.println(c.matches("\\+?-?\\d*"));    //true

        System.out.println(a.matches("(-|\\+)?\\d*"));  //  true - "+" здесь обычный, а не специальный, поэтому нужно "+\\"
        System.out.println(b.matches("(-|\\+)?\\d*"));  //  true - "+" здесь обычный, а не специальный, поэтому нужно "+\\"
        System.out.println(c.matches("(-|\\+)?\\d*"));  //  true - "+" здесь обычный, а не специальный, поэтому нужно "+\\"

        String d = "g56161";
        System.out.println(d.matches("([a-zA-Z])?\\d+"));    //true - любая англ буква, а дальше цифры
        d = "gdgsd56161";
        System.out.println(d.matches("[a-zA-z]+\\d+"));     //true
        d = "gdg113dgs333dgs11133fhhkhsd56161";
        System.out.println(d.matches("[a-zA-z13]+\\d+"));   //true

        String e = "hello";
        System.out.println(e.matches("[^abcd]*"));          //true
        e = "adf";
        System.out.println(e.matches("[^abcd]*"));          //false

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "http://www.tut.by";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));  //true
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));  //true
        System.out.println(url3.matches("http://www\\..+\\.(com|ru)"));  //false

        String f = "123";
        System.out.println(f.matches("\\d{2}"));        //false
        f = "13";
        System.out.println(f.matches("\\d{2}"));        //true
        System.out.println(f.matches("\\d{3,}"));       //false
        f = "1234";
        System.out.println(f.matches("\\d{2,}"));       //true

        f = "fgaafb";
        System.out.println(f.matches("\\w"));           //false, здесь больше 1 англ буквы
        System.out.println(f.matches("\\w+"));          //true
        f = "abcdefёплй";
        System.out.println(f.matches("\\w+"));          //false, здесь есть не только англ буквы
    }
}
