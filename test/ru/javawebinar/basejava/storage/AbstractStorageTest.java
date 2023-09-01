package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.List;

public abstract class AbstractStorageTest {
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String FULL_NAME_1 = "Иванов Александр";
    private static final String FULL_NAME_2 = "Иванов Константин";
    private static final String FULL_NAME_3 = "Иванов Константин";
    private static final String FULL_NAME_4 = "Иванов Петр";
    protected static final String UUID_NOT_EXIST = "dummy";
    protected static final Resume RESUME_1;
    protected static final Resume RESUME_2;
    protected static final Resume RESUME_3;
    protected static final Resume RESUME_4;
    protected Storage storage;

    static {
        RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
        RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
        RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
        RESUME_4 = new Resume(UUID_4, FULL_NAME_4);

//        RESUME_1 = new Resume(UUID_1);
//        RESUME_2 = new Resume(UUID_2);
//        RESUME_3 = new Resume(UUID_3);
//        RESUME_4 = new Resume(UUID_4);
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    private void assertSize(int size) throws Exception {
        Assert.assertEquals(size, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
        Resume[] expected = new Resume[]{};
        Assert.assertArrayEquals(expected, storage.getAllSorted().toArray());
    }

    @Test
    public void update() throws Exception {
        storage.update(RESUME_1);
        assertGet(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistException() throws Exception {
        storage.update(RESUME_4);
    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        List<Resume> existed = storage.getAllSorted();
        Assert.assertArrayEquals(expected, existed.toArray());
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertGet(RESUME_2);
        assertSize(2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_2);
    }

    private void assertGet(Resume resume) throws Exception {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }
}