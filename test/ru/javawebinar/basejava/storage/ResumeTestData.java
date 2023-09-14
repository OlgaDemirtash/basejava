package ru.javawebinar.basejava.storage;

import org.junit.Test;
import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ResumeTestData {

    private final static Resume RESUME_1;

    public ResumeTestData() {

    }

    static {
        RESUME_1 = new Resume("Григорий Кислин");
        Map<ContactType, String> contacts = new HashMap<>();
        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "skype:grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.PROFILE_LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.PROFILE_GITHUB, "https://github.com/gkislin");
        contacts.put(ContactType.PROFILE_STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.HOMEPAGE, "http://gkislin.ru/");

        Map<SectionType, AbstractSection> sections = new HashMap<>();
        sections.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям"));

        sections.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));

        ListSection achievement = new ListSection();
        achievement.add("Организация команды и успешная реализация " +
                "Java проектов для сторонних заказчиков: приложения " +
                "автопарк на стеке Spring Cloud/микросервисы, система" +
                " мониторинга показателей спортсменов на Spring Boot, " +
                "участие в проекте МЭШ на Play-2, многомодульный Spring Boot " +
                " + Vaadin проект для комплексных DIY смет");
        achievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\"," +
                "\"Java Enterprise\", \"Многомодульный maven. Многопоточность." +
                " XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие " +
                "(JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
        sections.put(SectionType.ACHIEVEMENT, achievement);

        ListSection qualifications = new ListSection();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle," +
                " MySQL, SQLite, MS SQL, HSQLDB");
        sections.put(SectionType.QUALIFICATIONS, qualifications);

        Company company1 = new Company("Coursera", "https://www.coursera.org/course/progfun");
        company1.addPeriod(LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1),
                "'Functional Programming Principles in Scala' by Martin Odersky",
                "");
        Company company2 = new Company("Luxsoft",
                "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366");
        company2.addPeriod(LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 3, 1),
                "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'",
                "");
        CompanySection educationSection = new CompanySection();
        educationSection.addCompany(company1);
        educationSection.addCompany(company2);
        sections.put(SectionType.EDUCATION, educationSection);

        company1 = new Company("Java Online Projects", "http://javaops.ru/");
        company1.addPeriod(LocalDate.of(2013, 10, 1), null, "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        company2 = new Company("Wrike", "https://www.wrike.com/");
        company2.addPeriod(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1,
                1), "Старший разработчик (backend)", "Проектирование и разработка " +
                "онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis," +
                " Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по " +
                "OAuth1, OAuth2, JWT SSO.");
        CompanySection experienceSection = new CompanySection();
        experienceSection.addCompany(company1);
        experienceSection.addCompany(company2);
        sections.put(SectionType.EXPERIENCE, experienceSection);

        RESUME_1.setContacts(contacts);
        RESUME_1.setSections(sections);
    }

    @Test
    public void print() throws Exception {

        Map<ContactType, String> contacts;
        Map<SectionType, AbstractSection> sections;

        System.out.println(RESUME_1.getFullName());

        contacts = RESUME_1.getContacts();
        for (ContactType contactType : ContactType.values()) {
            System.out.println(contactType.getTitle() + " " + contacts.get(contactType));
        }

        System.out.println("-----------------------------------------------------");
        sections = RESUME_1.getSections();
        for (SectionType sectionType : SectionType.values()) {
            System.out.println();
            System.out.println(sectionType.getTitle());
            sections.get(sectionType).print();
        }
    }
}