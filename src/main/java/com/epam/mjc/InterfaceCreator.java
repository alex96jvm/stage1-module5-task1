package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (!Character.isUpperCase(str.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer num : x) {
                if(num % 2 == 0) list.add(num);
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(str -> !str.matches("^[A-Z].*\\b(\\w+\\b\\s+){2,}\\w+\\.$"));
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : x){
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> list = new ArrayList<>(x);
            list.addAll(y);
            return list;
        };
    }
}
