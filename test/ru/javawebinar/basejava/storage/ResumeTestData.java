package ru.javawebinar.basejava.storage;

import org.junit.Test;
import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResumeTestData {

    private final static Resume RESUME_1;

    public ResumeTestData() {

    }

    static {
        RESUME_1 = new Resume("Григорий Кислин");
        setMockData(RESUME_1);

    }

    @Test
    public void print() throws Exception {

        EnumMap<ContactType, String> contacts;
        EnumMap<SectionType, AbstractSection> sections;

        System.out.println(RESUME_1.getFullName());

        contacts = RESUME_1.getContacts();

        for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " " + entry.getValue());
        }
        System.out.println("-----------------------------------------------------");
        sections = RESUME_1.getSections();
        for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
            System.out.println("\n" + entry.getKey().getTitle());
            System.out.println(entry.getValue());
        }
    }

    public static Resume getResume(String UUID, String fullName) {
        Resume resume = new Resume(UUID, fullName);
        setMockData(resume);
        return resume;
    }

    public static void setMockData(Resume resume) {
        EnumMap<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(ContactType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactType.SKYPE, "skype:grigory.kislin");
        contacts.put(ContactType.EMAIL, "gkislin@yandex.ru");
        contacts.put(ContactType.PROFILE_LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactType.PROFILE_GITHUB, "https://github.com/gkislin");
        contacts.put(ContactType.PROFILE_STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(ContactType.HOMEPAGE, "http://gkislin.ru/");

        EnumMap<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
        sections.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям"));

        sections.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));
        List<String> achievements = new ArrayList<>();
        achievements.add("Организация команды и успешная реализация " +
                "Java проектов для сторонних заказчиков: приложения " +
                "автопарк на стеке Spring Cloud/микросервисы, система" +
                " мониторинга показателей спортсменов на Spring Boot, " +
                "участие в проекте МЭШ на Play-2, многомодульный Spring Boot " +
                " + Vaadin проект для комплексных DIY смет");
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\"," +
                "\"Java Enterprise\", \"Многомодульный maven. Многопоточность." +
                " XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие " +
                "(JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
        ListSection achievementSection = new ListSection(achievements);
        sections.put(SectionType.ACHIEVEMENT, achievementSection);
        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle," +
                " MySQL, SQLite, MS SQL, HSQLDB");
        ListSection qualificationSection = new ListSection(qualifications);
        sections.put(SectionType.QUALIFICATIONS, qualificationSection);

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
        Company company3 = new Company("Siemens AG",
                "https://www.siemens.ru");
        company3.addPeriod(LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1),
                "3 месяца обучения мобильным IN сетям (Берлин)",
                "");
        Company company4 = new Company("Alcatel",
                "http://www.alcatel.ru/");
        company4.addPeriod(LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1),
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                "");

        Company company5 = new Company("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики",
                "http://www.ifmo.ru/");
        company5.addPeriod(LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1),
                "Аспирантура (программист С, С++)",
                "");
        company5.addPeriod(LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1),
                "Инженер (программист Fortran, C)",
                "");

        List<Company> educationCompanies = new ArrayList<>();
        educationCompanies.add(company1);
        educationCompanies.add(company2);
        educationCompanies.add(company3);
        educationCompanies.add(company4);
        educationCompanies.add(company5);
        CompanySection educationSection = new CompanySection(educationCompanies);
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
        List<Company> experienceCompanies = new ArrayList<>();
        experienceCompanies.add(company1);
        experienceCompanies.add(company2);

        CompanySection experienceSection = new CompanySection(experienceCompanies);
        experienceSection.addCompany(company1);
        experienceSection.addCompany(company2);
        sections.put(SectionType.EXPERIENCE, experienceSection);

        resume.setContacts(contacts);
        resume.setSections(sections);
    }
}