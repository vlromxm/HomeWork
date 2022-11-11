package ua.romanenko.module.models;

import ua.romanenko.module.enums.Type;

import java.util.ArrayList;
import java.util.List;


public class Invoice {
    List<Technique> techniqueList = new ArrayList<>();
    private Customer customer;
    private Type type;

    public Invoice(List<Technique> techniqueList, Customer customer, Type type) {
        this.techniqueList = techniqueList;
        this.customer = customer;
        this.type = type;
    }

    public Invoice(List<Technique> techniqueList, Type type) {
        this.techniqueList = techniqueList;
        this.type = type;
    }

    public List<Technique> getTechniqueList() {
        return techniqueList;
    }

    public void setTechniqueList(List<Technique> techniqueList) {
        this.techniqueList = techniqueList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n"+"Invoice" + "\n" +
                "Technique - " + techniqueList + "\n" +
                "Type - " + type;
    }
}