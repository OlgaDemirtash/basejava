package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(r.getUuid());
        } else
            storage[index] = r;
        }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public final void save(Resume r) {
        if (size >= storage.length) {
            throw new StorageException("Хранилище переполнено", r.getUuid());
        } else if (getIndex(r.getUuid()) > -1) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void insertResume(Resume r);

    protected abstract void removeResume(int index);

    protected abstract int getIndex(String uuid);

}