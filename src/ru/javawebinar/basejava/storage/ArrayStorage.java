package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void insertResume(Resume r) {
        storage[size] = r;
    }

    @Override
    public void removeResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void updateResume(int index, Resume r) {
        storage[index]  = r;
    }

    @Override
    protected Resume getObjectByIndex(int index) {
        return storage[index];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
