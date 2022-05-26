package com.shinho.coding.java8.functionalinterface;

public interface Bar {
    void printName();

    // 새 기능 추가가 필요해졌다.
    //void printNameUpperCase();  // 컴파일 에러; 모든 구현체들에 대해서 구현해주어야 함

    // 그래서 요렇게

    /**
     * @implSpec
     * 디폴트 메소드는 이런식으로 문서화가 중요!
     */
    default void printNameUpperCase() {
        System.out.println("DefaultBar".toUpperCase());
    }
    
    // 유틸리티성 메소드
    static void printAnything() {
        System.out.println("Bar");
    }
}
