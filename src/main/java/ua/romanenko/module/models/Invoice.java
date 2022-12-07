package ua.romanenko.module.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.romanenko.module.enums.Type;
import ua.romanenko.module.services.PersonService;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    List<Technique> techniqueList;
    private Customer customer;
    private Type type;

    public Invoice(List<Technique> list, Type type) {
        this.techniqueList = list;
        this.type = type;
    }

    public Invoice(List<Technique> list, Type type, Customer customer) {
        this.type = type;
        this.techniqueList = list;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "\n" + techniqueList + "\n" +
                "[ Customer " + customer + " ]" + "\n" +
                "[ Type = " + type + " ]" + "\n";
    }
}