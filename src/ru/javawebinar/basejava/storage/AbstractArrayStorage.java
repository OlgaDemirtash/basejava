package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage;
    protected int size = 0;

    {
        storage = new Resume[STORAGE_LIMIT];

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void aUpdate(Resume r, Object searchKey) {
        storage[(int) searchKey] = r;
    }

    @Override
    protected void aSave(Resume r) {
        if (size == storage.length) {
            throw new StorageException("Хранилище переполнено", r.getUuid());
        } else {
            insertResume(r);
            size++;
        }
    }

    @Override
    protected Resume aGet(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void aDelete(Object searchKey) {
        removeResume((int) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void insertResume(Resume r);

    protected abstract void removeResume(int index);

    protected abstract Object getSearchKey(String uuid);

}