package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends AbstractSection {

    protected final List<String> info = new ArrayList<>();

    public ListSection() {

    }

    @Override
    public void print() {

        for (String i : info) {
            System.out.println("*    " + i);
        }
    }

    public void add(String line) {

        info.add(line);
    }

}
