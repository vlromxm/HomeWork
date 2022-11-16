package ua.romanenko.module.services;

import ua.romanenko.module.models.Customer;

import java.util.List;
import java.util.Random;

public class PersonService {

    public static Customer generateRandomCustomer() {
        Random random = new Random();
        Customer customer = new Customer();
        customer.setId(random.nextInt(1, 100));
        customer.setAge(random.nextInt(15, 80));

        List<String> emails = List.of("asdf@gmail.com", "reta@gmail.com", "sdds@gmail.com",
                "asdfgtr@gmail.com", "asffre@gmail.com", "tytre@ukr.net", "hfyfhf@gmail.com",
                "kokla@gmail.com", "sdfdsqqq@ukr.net", "koalala@gmail.com");
        String email = emails.get(random.nextInt(1, emails.size()) - 1);
        customer.setEmail(email);
        return customer;
    }
}
