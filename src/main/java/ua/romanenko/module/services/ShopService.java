package ua.romanenko.module.services;

import ua.romanenko.module.enums.Type;
import ua.romanenko.module.models.Invoice;
import ua.romanenko.module.models.Technique;
import ua.romanenko.module.models.Telephone;
import ua.romanenko.module.models.Television;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ua.romanenko.module.Main.CONST_PRICE;

public class ShopService {

    private final String TELEPHONE = "Telephone";
    private final String TELEVISION = "Television";
    private final String NONE = "none";

    public List<Technique> techniqueList;
    private final Random random = new Random();

    public ShopService() {
        techniqueList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("goods.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                techniqueList = parseTechniqueFromString(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Technique> parseTechniqueFromString(String line) {
        List<Technique> techniqueList = new ArrayList<>();
        List<Telephone> telephoneList = new ArrayList<>();
        List<Television> televisionList = new ArrayList<>();
        String[] techniqueArray = line.split(",");
        for (int i = 0; i < techniqueArray.length - 1; i++) {
            if (TELEPHONE.equals(techniqueArray[0])) {
                Telephone telephone = new Telephone();
                telephone.setTypeOfTechnique(techniqueArray[0]);
                telephone.setSeries(techniqueArray[1]);
                telephone.setModel(techniqueArray[2]);
                telephone.setScreenType(techniqueArray[4]);
                telephone.setPrice(Integer.parseInt(techniqueArray[6]));
                telephoneList.add(telephone);
            } else if (TELEVISION.equals(techniqueArray[0])) {
                Television television = new Television();
                television.setTypeOfTechnique(techniqueArray[0]);
                television.setSeries(techniqueArray[1]);
                television.setDiagonal(Integer.parseInt(techniqueArray[3]));
                television.setCountry(techniqueArray[5]);
                television.setPrice(Integer.parseInt(techniqueArray[6]));
                televisionList.add(television);
            }
        }
        techniqueList.addAll(telephoneList);
        techniqueList.addAll(televisionList);
        return techniqueList;
    }

    public Invoice getRandomInvoice() {
        List<Technique> randomTechniqueList = createRandomTechniqueList();
        Type type = returnType(randomTechniqueList);
        return new Invoice(randomTechniqueList, type);
    }

    private List<Technique> createRandomTechniqueList() {
        int linesCount = random.nextInt(1, 5);

        List<Technique> invoiceTechnique = new ArrayList<>();
        List<Technique> allTechnique = new ArrayList<>();

        for (int i = 0; i < linesCount; i++) {
            int randomElementIndex = random.nextInt(0, techniqueList.size() - 1);
            invoiceTechnique.add(techniqueList.get(randomElementIndex));
        }
        return invoiceTechnique;
    }

    private Type returnType(List<Technique> techniqueList) {
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
}
