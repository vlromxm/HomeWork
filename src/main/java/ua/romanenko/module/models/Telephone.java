package ua.romanenko.module.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Telephone extends Technique {

    private String model;
    private String diagonal;
    private String series;
    private String screenType;
    private String country;
    private int price;

    public Telephone(String series, String screenType, int price, String model, String diagonal, String country) {
        super(series, screenType, price);
        this.model = model;
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "model='" + model + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
