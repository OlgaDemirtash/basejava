package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class CompanySection extends AbstractSection {

    protected final List<Company> companies = new ArrayList<>();

    public CompanySection() {

    }

    public void addCompany(Company company) {

        companies.add(company);
    }

    public void print() {

        for (Company listEntry : companies) {
            System.out.println();
            System.out.println(listEntry);
            for (Period period : listEntry.getPeriods()) {
                System.out.println(period);
            }
        }
    }
}
