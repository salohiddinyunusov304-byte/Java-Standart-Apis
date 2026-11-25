package org.example;

public class Main {
    public static void main(String[] args) {
        /// Build tools - 2 xil:Maven, Grandle
        /// Project Lombok - kop takroriy kodni yozishni kamaytiradi
        // @ - anotatsiya orqali ishlatamiz

        User user = User.builder()
                .id(101L)
                .name("Salohiddin")
                .build();

        System.out.println(user.toString());
    }
}
