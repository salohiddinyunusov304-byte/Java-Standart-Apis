package org.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
       /// Functional Interfeys - faqat 1 ta abstract methodga ega, lambda( -> ) va method reference (::) bn iwlaw

        // old version
        Calculator calculator = new Calculator() {
            @Override
            public int clculate(int a, int b) {
                return a + b;
            }
        };

        System.out.println(calculator.clculate(2, 3));

        // new version
        Calculator add = (a, b) -> a + b;
        Calculator minus = (a, b) -> a - b;

        Calculator.info();
        add.getResult(add.clculate(2, 3));
        minus.getResult(minus.clculate(5, 3));

        /// 4 xil Functional Interfeys bor (Predicate<T>, Function<T, R>, Consumer<T>, Suplier<T>, ...)

        // Predicate: son juftmi
        Predicate<Integer> juftmu = son -> son  % 2 == 0;
        System.out.println(juftmu.test(5));

        // Function: matn uzunligini topish
        Function<String, Integer> uzunlik = matn -> matn.length();
        System.out.println(uzunlik.apply("Salom"));

        // Consumer: elementni ekranga chiqarish
        Consumer<String> chiqar = s -> System.out.println(s);
        List.of("Ali", "Vali", "Sali").forEach(chiqar);

        // Supplier: tasodifiy son qaytarish
        Supplier<Double> tassodifiy = () -> Math.random() * 10;
        System.out.println(tassodifiy.get());

        /// :: - Method reference bn ishlatish
        List<String> tillar = List.of("Ali", "Vali", "Sali");

        // lambda orniga method reference
        tillar.forEach(System.out :: println);
    }
}
