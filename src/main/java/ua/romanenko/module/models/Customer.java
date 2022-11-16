package ua.romanenko.module.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String email;
    private int age;

    @Override
    public String toString() {
        return "id=" + id +
                ", email= " + email +
                ", age=" + age;
    }
}
