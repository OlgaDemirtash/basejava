package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {

    protected final List<String> info = new ArrayList<>();

    public ListSection() {

    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        for (String i : info) {
            output.append("*    ").append(i).append("\n");
        }
        return output.toString();
    }

    public void add(String line) {

        info.add(line);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ListSection that)) return false;
        return info.equals(that.info);
    }

    @Override
    public int hashCode() {

        return Objects.hash(info);
    }
}
