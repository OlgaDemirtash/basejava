package ru.javawebinar.basejava.model;

public class TextSection extends AbstractSection {

    protected final String info;

    public TextSection(String info) {

        this.info = info;
    }

    @Override
    public String toString() {

        return info;
    }
}
