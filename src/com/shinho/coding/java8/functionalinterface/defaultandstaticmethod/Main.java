package com.shinho.coding.java8.functionalinterface.defaultandstaticmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);

        /*for (String n : name) {
            System.out.println(n);
        }*/

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==========================");
        while (spliterator1.tryAdvance(System.out::println));

        Set<String> collect = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet());

        name.removeIf(s -> s.startsWith("K"));

        name.forEach(System.out::println);
    }
}
