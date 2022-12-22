package ua.romanenko.hw23.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "device_id")
    private long id;
    @Column(name = "type")
    private String type;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private int price;
    @Column(name = "date_of_manufacture")
    private Date dateOfManufacture;
    @Column(name = "description")
    private String description;
    @Column(name = "availability")
    private boolean availability;
    @Transient
    private long factoryId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "factory_id")
    private Factory factory;

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

    public Device(long id, String type, String model, int price, Date dateOfManufacture, String description, boolean availability, long factoryId, Factory factory) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.description = description;
        this.availability = availability;
        this.factoryId = factoryId;
        this.factory = factory;
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
                ", factory=" + factory +
                '}';
    }
}
