package com.shinho.coding.java8.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {
    public static void main(String[] args) {
        /*RunSomething runSomething = new RunSomething() {
            // 익명 내부 클래스 anonymous inner class
            @Override
            public void doIt() {

            }
        };*/

        // 함수형 인터페이스를 구현할 때 쓸 수 있는 람다 형태의 표현식
        RunSomething runSomething = number -> number + 10;  // 마치 다른 언어에서의 함수처럼 보이지만 사실 특수한 형태의 오브젝트라고 봐야함
        // 그렇기 때문에 변수에 할당하고, 메소드 파라미터로 전달하거나 리턴 타입으로 사용할 수도 있다.
        // First class object로 사용할 수 있다
        // 고차 함수(High order function)

        // 순수 함수: 동일한 입력에 대해서는 같은 값을 리턴하도록 보장되야 한다.
        // 즉, 상태값을 갖으면 안되고 외부의 값을 변경하려 하면 안된다.
        runSomething.doIt(20);
        runSomething.doIt(20);
        runSomething.doIt(20);

        Function<Integer, Integer> plus10 = number -> number + 10;
        Function<Integer, Integer> multiply2 = i -> i * 2;

        System.out.println(plus10.apply(1));
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2));

        Consumer<Integer> printT = i -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithShinho = s -> s.startsWith("Shinho");

        UnaryOperator<Integer> plus100 = i -> i + 100;  // Function의 자식 인터페이스. 입력 및 결과 타입이 같을 때 사용

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        /* final */ int baseNumber = 10; // 사실상 final인 경우, 생략가능

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }
        
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 쉐도잉
            }
        };

        // 람다
        IntConsumer printInt = /* baseNumber 선언 불가 */ i -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
