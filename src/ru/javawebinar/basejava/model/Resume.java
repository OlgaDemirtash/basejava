package ru.javawebinar.basejava.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume { // implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;

    private Map<ContactType, String> contacts = new HashMap<>();
    private Map<SectionType, AbstractSection> sections = new HashMap<>();

    public Resume() {

        this.uuid = UUID.randomUUID().toString();
        fullName = "";
    }

    public Resume(String fullName) {

        this.uuid = UUID.randomUUID().toString();
        this.fullName = fullName;
    }

    public Resume(String uuid, String fullName) {

        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Map<ContactType, String> getContacts() {

        return contacts;
    }

    public void setContacts(Map<ContactType, String> contacts) {

        this.contacts = contacts;
    }

    public Map<SectionType, AbstractSection> getSections() {

        return sections;
    }

    public void setSections(Map<SectionType, AbstractSection> sections) {

        this.sections = sections;
    }

    public String getFullName() {

        return fullName;
    }

    public String getUuid() {

        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

//    @Override
//    public int compareTo(Resume o) {
//        return uuid.compareTo(o.uuid);
//    }
}
