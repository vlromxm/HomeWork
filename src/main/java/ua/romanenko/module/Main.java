package ua.romanenko.module;

import ua.romanenko.module.models.Customer;
import ua.romanenko.module.models.Invoice;
import ua.romanenko.module.services.PersonService;
import ua.romanenko.module.services.ShopService;
import ua.romanenko.module.services.StatisticsService;

import java.io.FileWriter;
import java.time.LocalDate;

public class Main {

    public static final int CONST_PRICE = 1000;

    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter("CreatedOrder.txt");) {
            ShopService shopService = new ShopService();
            Invoice receivedInvoice = shopService.getRandomInvoice();
            Customer customer = PersonService.generateRandomCustomer();
            LocalDate localDate = LocalDate.now();

            fileWriter.append("[").append(String.valueOf(localDate)).append("]").append("\n");
            fileWriter.append("[").append(String.valueOf(customer)).append("]").append("\n");
            fileWriter.append("[").append(String.valueOf(receivedInvoice)).append("]");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
