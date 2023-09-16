package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Period {

    private LocalDate start;
    private LocalDate end;
    private String title;
    private String description;

    public Period(LocalDate start, LocalDate end, String title, String description) {

        this.start = start;
        this.end = end;
        this.title = title;
        this.description = description;
    }

    public LocalDate getStart() {

        return start;
    }

    public void setStart(LocalDate start) {

        this.start = start;
    }

    public LocalDate getEnd() {

        return end;
    }

    public void setEnd(LocalDate end) {

        this.end = end;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String toString() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yyyy");

        return start.format(dateTimeFormatter) + " - " +
                ((end == null) ? "Сейчас" : end.format(dateTimeFormatter)) + " " + title + ((description == "") ? "" : " \n" + description);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Period period)) return false;
        return getStart().equals(period.getStart()) && Objects.equals(getEnd(), period.getEnd()) && getTitle().equals(period.getTitle()) && Objects.equals(getDescription(), period.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStart(), getEnd(), getTitle(), getDescription());
    }
}
