package ua.romanenko.hw19.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Box {
    @JsonProperty("from")
    private String from;
    @JsonProperty("material")
    private String material;
    @JsonProperty("color")
    private String color;
    @JsonProperty("max-lifting-capacity")
    private Capacity capacity;
    @JsonProperty("cargo")
    private Cargo cargo;
    @JsonProperty("delivery-date")
    private Date date;

    @Override
    public String toString() {
        return "Box{" +
                "from='" + from + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", capacity=" + capacity +
                ", cargo=" + cargo +
                ", date=" + date +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
