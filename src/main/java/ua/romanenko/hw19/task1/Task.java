package ua.romanenko.hw19.task1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> words = new ArrayList<>();
    private final List<String> rows = new ArrayList<>();

    public void writeText(){
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
    }
    public void saveText(){
        try (FileWriter fileWriter = new FileWriter("test.csv")) {
            for (String row : rows) {
                fileWriter.append(row + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        task.writeText();
        task.saveText();
    }
}