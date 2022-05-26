package com.shinho.coding.java8.functionalinterface;

public class DefaultBar implements Bar, Bar2 {

    @Override
    public void printName() {
        System.out.println("DefaultBar");
    }

    // default 메소드도 재정의할 수 있다.
    @Override
    public void printNameUpperCase() {
        // 충돌나면 직접 구현~
    }
}
