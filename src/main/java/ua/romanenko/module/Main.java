package ua.romanenko.module;

import ua.romanenko.module.models.Customer;
import ua.romanenko.module.models.Invoice;
import ua.romanenko.module.services.ShopService;

import java.io.FileWriter;
import java.time.LocalDate;

public class Main {

    public static final int CONST_PRICE = 1000;

    public static void main(String[] args) {

        ShopService shopService = new ShopService();
        Invoice receivedInvoice = shopService.getRandomInvoice();
        System.out.println(receivedInvoice);

        try (FileWriter fileWriter = new FileWriter("CreatedOrder.txt");) {
            Customer customer = new Customer(1, "customer@gmail.com", 25);
            LocalDate localDate = LocalDate.now();
            String time = String.valueOf(localDate);
            String invoice = String.valueOf(receivedInvoice);
            String user = String.valueOf(customer);
            fileWriter.append(time);
            fileWriter.append(user);
            fileWriter.append(invoice);
        } catch (Exception exception) {
            exception.printStackTrace();
        }



    }
}
