package ua.romanenko.hw23.generator;

import ua.romanenko.hw23.entity.Device;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GenerateDevice {

    private final Random random = new Random();

    public Device generateDevice(long factoryID) {
        String type = randomType();
        String model = randomModel();
        int price = randomPrice();
        Date dateOfManufacture = randomDate();
        String description = randomDescription();
        boolean availability = random.nextBoolean();
        return new Device(System.currentTimeMillis(), type, model, price, dateOfManufacture, description, availability, factoryID);
    }

    private String randomType() {
        List<String> types = List.of("Telephone", "Television", "Tablet", "Computer", "Camera");
        int randomType = random.nextInt(0, types.size());
        return types.get(randomType);
    }

    private String randomModel() {
        List<String> models = List.of("Samsung", "Apple", "Xiaomi", "Sony", "LG", "Philips");
        int randomModel = random.nextInt(0, models.size());
        return models.get(randomModel);
    }

    private int randomPrice() {
        int priceSize = random.nextInt(1000, 10000);
        int price = 0;
        for (int i = 0; i < priceSize - 1; i++) {
            price = i;
        }
        return price;
    }

    public static Date randomDate() {
        Calendar pastYear = Calendar.getInstance();
        pastYear.set(Calendar.YEAR, 2018);
        long past = pastYear.getTimeInMillis();

        Calendar presentYear = Calendar.getInstance();
        presentYear.set(Calendar.YEAR, 2022);
        long present = presentYear.getTimeInMillis();

        long diff = present - past + 1;
        Timestamp timestamp = new Timestamp(past + (long) (Math.random() * diff));
        return new Date(timestamp.getTime());
    }

    private String randomDescription() {
        List<String> descriptions = List.of("durable", "battery capacity", "strong case", "thin", "convenient to use");
        int randomDescription = random.nextInt(0, descriptions.size());
        return descriptions.get(randomDescription);
    }
}

