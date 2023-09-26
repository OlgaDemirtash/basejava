package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {

    protected final List<String> items;

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "Items must not be Null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void add(String line) {
        items.add(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection that)) return false;
        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (String i : items) {
            output.append("*    ").append(i).append("\n");
        }
        return output.toString();
    }
}
