package com.shinho.coding.java8.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Greeting {
    public static void main(String[] args) {
        //UnaryOperator<String> hi = s -> "hi " + s;
        UnaryOperator<String> hi = Greeting::hi;    // 구현하고자 한 람다식이 어느 특정 클래스의 스태틱 메소드랑 같을 경우, 스태틱 메소드 레퍼런스로 참조할 수 있다.
        hi.apply("shinho");

        Greeting greeting = new Greeting();
        //UnaryOperator<String> hello = s -> "hello " + s;
        UnaryOperator<String> hello = greeting::hello;  // 인스턴스 메소드 참조
        hello.apply("Shinho");

        Supplier<Greeting> newGreeting = Greeting::new; // 생성자 참조
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> shinhoGreeting = Greeting::new; // 위에랑은 다른 생성자임
        Greeting sino = shinhoGreeting.apply("sino");

        String[] names = { "keesun", "whiteship", "toby" };
        Arrays.sort(names, String::compareToIgnoreCase);
    }

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
