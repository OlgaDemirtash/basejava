package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import ru.javawebinar.basejava.exception.StorageException;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super();
        storage = new MapStorage();
    }
    @Override
    public void getAll() throws Exception {
        MapStorage expected = new MapStorage();
        expected.save(RESUME_1);
        expected.save(RESUME_2);
        expected.save(RESUME_3);
        Assert.assertArrayEquals(expected.getAll(), storage.getAll());
    }

    @Override
    public void saveStorageOverflow() {
        throw new StorageException("dummy", "dummy");
    }
}