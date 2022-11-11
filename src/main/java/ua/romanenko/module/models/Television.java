package ua.romanenko.module.models;

public class Television  extends Technique{

    private int diagonal;
    private String country;

    public Television(String typeOfTechnique, String series, String screenType, int price, int diagonal, String country) {
        super(typeOfTechnique, series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }
    public Television(){}

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television{" +
                "diagonal=" + diagonal +
                ", country='" + country + '\'' +
                '}';
    }
}
