package org.example;

import java.util.Comparator;
import java.util.List;

record Mahsulot(String nomi, String kategoriya, int narx) {}

public class Main {
    public static void main(String[] args) {
        /// Comparator<T> - bu 2 ta T tipdagi qiymatni solishtirishi uchun, qay biri oldin qay biri keyin kelishini aniqlash uchun
        List<Mahsulot> mahsulotlar = List.of(
                new Mahsulot("Telefon", "Elektronika", 800),
                new Mahsulot("Noutbuk", "Elektronika", 1200),
                new Mahsulot("Sichqoncha", "Elektronika", 800),
                new Mahsulot("Kitob", "Kitoblar", 20)
        );

        // 1. Kategoriya bo‘yicha (A-Z)
        // 2. Narx bo‘yicha kamayish tartibida (yuqoridan pastga)
        // 3. Narx ham bir xil bo‘lsa, nomi bo‘yicha (A-Z)
        Comparator<Mahsulot> tartib = Comparator
                .comparing(Mahsulot::kategoriya)
                .thenComparing(Comparator.comparingInt(Mahsulot::narx).reversed())
                .thenComparing(Mahsulot::nomi);

        List<Mahsulot> list = mahsulotlar.stream()
                .sorted(tartib)
                .toList();

        list.forEach(System.out::println);

        /// Collector - toList toMap kabi yigish uchun
        System.out.println(mahsulotlar.stream()
                .limit(3)
                .toList());
    }
}
