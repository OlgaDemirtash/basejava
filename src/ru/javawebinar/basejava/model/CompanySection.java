package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class CompanySection extends AbstractSection {

    protected final List<Company> companies;

    public CompanySection(List<Company> companies) {
        Objects.requireNonNull(companies, "Companies must not be Null");
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        companies.add(company);
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
}