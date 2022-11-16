package ua.romanenko.module.services;

import ua.romanenko.module.enums.Type;
import ua.romanenko.module.exception.IncorrectLineReadingException;
import ua.romanenko.module.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ua.romanenko.module.Main.CONST_PRICE;

public class ShopService {
    private static final String TELEPHONE = "Telephone";
    private static final String TELEVISION = "Television";

    public List<Technique> techniqueList;
    private final Random random = new Random();

    public ShopService() {
        techniqueList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("goods.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Technique technique = parseTechniqueFromString(line);
                techniqueList.add(technique);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Technique parseTechniqueFromString(String line) throws IncorrectLineReadingException {
        Telephone telephone = new Telephone();
        Television television = new Television();
        try {
            String[] techniqueArray = line.split(",");
            for (int i = 0; i < techniqueArray.length - 1; i++) {
                if (TELEPHONE.equals(techniqueArray[0])) {
                    telephone.setSeries(techniqueArray[1]);
                    telephone.setModel(techniqueArray[2]);
                    telephone.setDiagonal(techniqueArray[3]);
                    telephone.setScreenType(techniqueArray[4]);
                    telephone.setCountry(techniqueArray[5]);
                    telephone.setPrice(Integer.parseInt(techniqueArray[6]));
                    return telephone;
                } else if (TELEVISION.equals(techniqueArray[0])) {
                    television.setSeries(techniqueArray[1]);
                    television.setModel(techniqueArray[2]);
                    television.setDiagonal(Integer.parseInt(techniqueArray[3]));
                    television.setScreenType(techniqueArray[4]);
                    television.setCountry(techniqueArray[5]);
                    television.setPrice(Integer.parseInt(techniqueArray[6]));
                    return television;
                } else throw new IncorrectLineReadingException("Invalid line");
            }
        } catch (IncorrectLineReadingException exception) {
            exception.printStackTrace();
        }
        return null;
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

    public Type returnType(List<Technique> techniqueList) {
        int totalPrice = techniqueList
                .stream()
                .map(Technique::getPrice)
                .mapToInt(Integer::intValue)
                .sum();
        if (totalPrice > CONST_PRICE) {
            return Type.WHOLESALE;
        } else {
            return Type.RETAIL;
        }
    }

    public Invoice getRandomInvoice() {
        List<Technique> randomTechniqueList = createRandomTechniqueList();
        Customer customer = PersonService.generateRandomCustomer();
        Type type = returnType(randomTechniqueList);
        return new Invoice(randomTechniqueList, type, customer);
    }
}
