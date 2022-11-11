package ua.romanenko.module.services;
import ua.romanenko.module.models.Customer;
import java.util.List;
import java.util.Random;

public class PersonService {

    public Customer generateRandomCustomer(List<Customer>customerList){
        Random random = new Random();
        Customer customer;
        customer = customerList.get(random.nextInt(customerList.size()));
        return customer;
    }
}
