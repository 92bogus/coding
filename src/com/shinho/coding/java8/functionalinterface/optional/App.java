package com.shinho.coding.java8.functionalinterface.optional;

import com.shinho.coding.java8.functionalinterface.stream.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        //        if (optional.isPresent()) {
        //            OnlineClass onlineClass = optional.get();
        //            System.out.println(onlineClass.getTitle());
        //        }

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass = optional.orElse(createNewClass()); // else가 아니라도 무조건 create 실행함
        OnlineClass onlineClass1 = optional.orElseGet(App::createNewClass); // orElseGet은 else면 실행하지 않는다.
        // orElse는 이미 만들어져있는 객체를 넘길 때, orElseGet은 동적으로 추가로 만들어줄때

    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "New class", false);
    }
}
