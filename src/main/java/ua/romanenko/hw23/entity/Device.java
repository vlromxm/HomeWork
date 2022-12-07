package ua.romanenko.hw23.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Device {
    private long id;
    private String type;
    private String model;
    private int price;
    private Date dateOfManufacture;
    private String description;
    private boolean availability;
    private long factoryId;

    public Device(long id, String type, String model, int price, Date dateOfManufacture, String description, boolean availability, long factoryId) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.description = description;
        this.availability = availability;
        this.factoryId = factoryId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", dateOfManufacture=" + dateOfManufacture +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                ", factoryId=" + factoryId +
                '}';
    }
}
