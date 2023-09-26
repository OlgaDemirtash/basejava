package ru.javawebinar.basejava.util;

import java.io.File;
import java.io.IOException;

public class MainFileRecursive {

    public static void main(String[] args) {
        String filePath = ".//";
        File rootDirectory = new File(filePath);
        try {
            System.out.println(rootDirectory.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        if (rootDirectory.isDirectory()) {
            printFileNames(rootDirectory, 0);
        } else {
            System.out.println("Provided name " + filePath + " is not a directory");
        }
    }

    public static void printFileNames(File dir, int indent) {
        File[] list = dir.listFiles();
        if (list != null) {
            indent++;
            for (File nextItem : list) {
                if (nextItem.isDirectory()) {
                    System.out.println(" ".repeat(indent) + ">>" + nextItem.getName());
                    printFileNames(nextItem, indent);
                } else {
                    System.out.println(" ".repeat(indent) + nextItem.getName());
                }
            }
        }
    }
}


