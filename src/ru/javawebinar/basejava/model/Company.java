package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

    private final String title;
    private final Link website;
    private final List<Period> periods = new ArrayList<>();

    public Company(String title, String website) {
        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
        this.website = new Link(title, website);
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website.getUrl();
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void addPeriod(LocalDate start, LocalDate end, String title, String description) {
        Period period = new Period(start, end, title, description);
        periods.add(period);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return getTitle().equals(company.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    @Override
    public String toString() {
        return title + " " + website.getUrl();
    }
}

