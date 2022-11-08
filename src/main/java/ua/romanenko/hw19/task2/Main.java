package ua.romanenko.hw19.task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper om = new ObjectMapper();
            Box box = om.readValue(new File("box.json"), Box.class);
            System.out.println(box);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
