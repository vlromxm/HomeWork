package ua.romanenko.module.services;

import ua.romanenko.module.enums.Type;
import ua.romanenko.module.exception.IncorrectLineReadingException;
import ua.romanenko.module.models.*;

import java.util.*;

public class StatisticsService {
    List<Technique> techniqueList;
    private final Random random = new Random();
    ShopService shopService = new ShopService();

    public StatisticsService() {

        techniqueList = shopService.techniqueList;
    }

    private List<Technique> createRandomTechniqueList() {
        int linesCount = random.nextInt(1, 5);
        List<Technique> invoiceTechnique = new ArrayList<>();
        for (int i = 0; i < linesCount; i++) {
            int randomElementIndex = random.nextInt(0, techniqueList.size() - 1);
            invoiceTechnique.add(techniqueList.get(randomElementIndex));
        }
        return invoiceTechnique;
    }

    public Invoice getInvoiceWithRandomTechniqueAndCustomer() {
        List<Technique> list = createRandomTechniqueList();
        Type type = shopService.returnType(list);
        Customer customer = PersonService.generateRandomCustomer();
        return new Invoice(list, type, customer);
    }

//    public List<Invoice> getAllInvoices() {
//        List<Invoice> invoices = new ArrayList<>();
//        Invoice invoice = getInvoiceWithRandomTechniqueAndCustomer();
//
//
//    }


    public static void main(String[] args) {
        StatisticsService statisticsService = new StatisticsService();
        Invoice receivedInvoice = statisticsService.getInvoiceWithRandomTechniqueAndCustomer();

        System.out.println(receivedInvoice);
    }
}
