package org.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       // filter(Predicate) - shartga mos keladigan element qoldiradi
       // map(Function) - har bir elementni boshqa tip ga ozgartiradi
        // sorted() - tartiblash
        // distinct() - takroriylarni olib tashlaydi
        // limit/skip(n) - shekalsh yoki dastlabki n tasini tashlavorish
        // collect() - natijani Collectionga yigadi
        // anyMatch(predicate) — kamida bitta element shartga mos kelsa true qaytaradi.
        // allMatch(predicate) — barcha elementlar shartga mos kelsa true qaytaradi.

        List<String> names = List.of("Ali", "Vali", "Anvar");

        // 'A' harfi bilan boshlanadigan ismlarni katta harfga o‘tkazib, ro‘yxatga yig‘ish
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .toList(); // Java 16+ da qulay usul (eski versiyalarda: .collect(Collectors.toList()))

        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 5, 10, 0, 22);

        List<Integer> list = numbers.stream()
                .filter(n -> n % 2 == 0)
                .skip(1)
                .limit(1)
                .peek(System.out::println)
                .toList();

        System.out.println(list);

        System.out.println(numbers);

        boolean b = numbers.stream()
                .allMatch(n -> n % 2 == 1);
        System.out.println(b);

        System.out.println(numbers.stream()
                .findAny());

        // reduce()

        System.out.println(numbers.stream()
                .reduce(Integer::sum));

        // map / flatMap
        List<List<String>> guruhlar = List.of(
                List.of("Java", "Spring"),
                List.of("SQL", "Docker")
        );

        // map - har bir elementni 1 ta yangi qiymatga ozgartiradi
        long count = guruhlar.stream().map(List::size).count();
        System.out.println(count);

        // flatMap - 1 ta umumiy streamga birlashtiradi
        List<String> barchaTexnologiyalar = guruhlar.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(barchaTexnologiyalar);


    }
}
