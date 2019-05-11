package com.handl.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestOne {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        List<Apple> heavierThan150g = inventory.stream().filter((Apple a) -> a.getWi() > 50).collect(Collectors.toList());
    }
}
