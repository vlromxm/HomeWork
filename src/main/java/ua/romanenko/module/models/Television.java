package ua.romanenko.module.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Television extends Technique {

    private String model;
    private int diagonal;
    private String series;
    private String screenType;
    private String country;
    private int price;

    public Television(String series, String screenType, int price, String model, int diagonal, String country) {
        super(series, screenType, price);
        this.model = model;
        this.diagonal = diagonal;
        this.country = country;
    }
}

