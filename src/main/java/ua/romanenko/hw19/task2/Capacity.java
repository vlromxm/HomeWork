package ua.romanenko.hw19.task2;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Capacity {
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("value")
    private int value;

    @Override
    public String toString() {
        return "Capacity{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
