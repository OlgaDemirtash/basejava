package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompanySection extends AbstractSection {

    protected final List<Company> companies = new ArrayList<>();

    public CompanySection() {

    }

    public void addCompany(Company company) {

        companies.add(company);
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        for (Company listEntry : companies) {
            output.append("\n").append(listEntry);
            for (Period period : listEntry.getPeriods()) {
                output.append("\n").append(period);
            }
        }
        return output.toString();
    }

    public List<Company> getCompanies() {

        return companies;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof CompanySection that)) return false;
        return getCompanies().equals(that.getCompanies());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompanies());
    }
}