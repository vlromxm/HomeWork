package ua.romanenko.module.models;

public class Telephone extends Technique{

    private String model;

    public Telephone(String typeOfTechnique, String series, String screenType, int price, String model) {
        super(typeOfTechnique, series, screenType, price);
        this.model = model;
    }
    public Telephone(){}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "model='" + model + '\'' +
                '}';
    }
}
