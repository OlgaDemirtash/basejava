package ru.javawebinar.basejava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) {
        String filePath = ".//.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printFileNames(File dir) {
        File[] list = dir.listFiles();
        if (list != null) {
            for (File nextItem : list) {
                if (nextItem.isDirectory()) {
                    printFileNames(nextItem);
                } else {
                    System.out.println(nextItem.getName());
                }
            }
        }
    }

}


