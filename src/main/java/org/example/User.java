package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Barcha getter, setter, toString, equals va hashCode metodlarini yaratadi
@NoArgsConstructor // Bo'sh konstruktor yaratadi: new User()
@AllArgsConstructor // Barcha maydonli konstruktor yaratadi: new User(1L, "Ali", "ali@mail.uz")
@Builder
public class User {
    private Long id;
    private String name;
}
