package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection extends AbstractSection {

    protected final String info;

    public TextSection(String info) {
        Objects.requireNonNull(info, "info must not be Null");
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextSection that)) return false;
        return getInfo().equals(that.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo());
    }

    @Override
    public String toString() {
        return info;
    }
}
