package com.shinho.coding.java8.functionalinterface;

@FunctionalInterface    // 함수형 인터페이스라고 명시적으로 선언
public interface RunSomething {
    int doIt(int number);    // 함수형 인터페이스란? 추상 메소드가 하나만 있는 인터페이스

    static void printName() {   // java8에 추가된 인터페이스의 정적메소드
        System.out.println("Shinho");
    }

    default void printAge() {   // 정적 메소드와 디폴트 메소드가 있어도 함수형 인터페이스는 변함이 없다.
        System.out.println("31");
    }
}
