package org.example;

@FunctionalInterface // abstract method bomi yomi tekshiradi
public interface Calculator {
    int clculate(int a, int b);

    default void getResult(int reault) {
        System.out.println("Result: " + reault);
    }

    static void info() {
        System.out.println("Bu Functional interfeys");
    }
}
