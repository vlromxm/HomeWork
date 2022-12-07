package ua.romanenko.hw23.generator;

import ua.romanenko.hw23.entity.Device;
import ua.romanenko.hw23.entity.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateFactory {

    private final Random random = new Random();

    public Factory generateFactory() {
        String name = randomFactoryName();
        String country = randomFactoryCountry();
        return new Factory(System.currentTimeMillis(), name, country);
    }

    private String randomFactoryName() {
        List<String> factories = List.of("Günter&Hauer", "EuroTechnique", "MobileUA", "Colorway", "Promate", "Hoco", "Baseus");
        return factories.get(random.nextInt(0, factories.size()));
    }

    private String randomFactoryCountry() {
        List<String> countries = List.of("China", "USA", "Great Britain", "Ukraine", "Canada", "France", "Germany");
        return countries.get(random.nextInt(0, countries.size()));
    }
}
