package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Link {

    private final String name;
    private final String url;

    public Link(String name, String url) {
        Objects.requireNonNull(name);
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link link)) return false;
        return getName().equals(link.getName()) && Objects.equals(getUrl(), link.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUrl());
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
