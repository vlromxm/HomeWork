package ua.romanenko.hw19.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cargo {
    @JsonProperty("name")
    private String name;
    @JsonProperty("clas")
    private String clas;

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
}
