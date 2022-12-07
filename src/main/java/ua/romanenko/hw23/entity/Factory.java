package ua.romanenko.hw23.entity;

import lombok.*;

@Data
@NoArgsConstructor
public class Factory {
    private long id;
    private String name;
    private String country;

    public Factory(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
