package ua.romanenko.module.models;

public class Technique {
    private String typeOfTechnique;
    private String series;
    private String screenType;
    private int price;

    public Technique(String typeOfTechnique, String series, String screenType, int price) {
        this.typeOfTechnique = typeOfTechnique;
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }

    public Technique() {
    }

    public String getTypeOfTechnique() {
        return typeOfTechnique;
    }

    public void setTypeOfTechnique(String typeOfTechnique) {
        this.typeOfTechnique = typeOfTechnique;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Technique{" +
                "typeOfTechnique='" + typeOfTechnique + '\'' +
                ", series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                '}';
    }
}
