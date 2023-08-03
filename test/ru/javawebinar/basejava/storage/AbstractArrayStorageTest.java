package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final String UUID_4 = "uuid4";
    protected Storage storage;

    public AbstractArrayStorageTest() {
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r1 = new Resume(UUID_1);
        Resume r2;
        storage.update(r1);
        r2 = storage.get(UUID_1);
        Assert.assertEquals(r1, r2);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumeArray = new Resume[3];
        resumeArray[0] = new Resume(UUID_1);
        resumeArray[1] = new Resume(UUID_2);
        resumeArray[2] = new Resume(UUID_3);
        Assert.assertArrayEquals(resumeArray, storage.getAll());
    }

    @Test
    public void save() throws Exception {
        Resume r = new Resume(UUID_4);
        storage.save(r);
        Assert.assertEquals(r,storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        Resume r = new Resume(UUID_2);
        storage.delete(r.getUuid());
        Assert.assertEquals(r,storage.get(r.getUuid()));
    }

    @Test
    public void get() throws Exception {
    Resume r1 = new Resume(UUID_2);
    Assert.assertEquals(r1,storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}