package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() {
        super();
        storage = new ListStorage();
    }

    @Override
    public void saveStorageOverflow() {
        throw new StorageException("Переполнение хранилища", "dummy");
    }
}