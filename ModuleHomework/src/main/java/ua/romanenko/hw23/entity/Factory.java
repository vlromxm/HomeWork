package ua.romanenko.hw23.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @Column(name = "factory_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "factory",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST )
    private List<Device> devices;

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
