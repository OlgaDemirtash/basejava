package ru.javawebinar.basejava.model;

public class TextSection extends AbstractSection {

    protected final String info;

    public TextSection(String info) {

        this.info = info;
    }

    public void print() {

        System.out.println(info);
    }

}
