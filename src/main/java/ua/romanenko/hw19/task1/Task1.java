package ua.romanenko.hw19.task1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                String row = String.join(",", words);
                rows.add(row);
                words.clear();
                scanner.close();
                break;
            }
            if (input.equals("next")) {
                String row = String.join(",", words);
                rows.add(row);
                words.clear();
            } else {
                words.add(input);
            }
        }
        try (FileWriter fileWriter = new FileWriter("test.csv")) {
            for (String row : rows) {
                fileWriter.append(row + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
