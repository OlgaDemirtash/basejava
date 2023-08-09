package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else
            updateResume(index, r);
    }


    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r);
        }
    }

    @Override
    public Resume get(String uuid) {

        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getObjectByIndex(index);
    }

    @Override
    public void delete(String uuid) {

        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        }
        removeResume(index);

    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume r);

    protected abstract void removeResume(int index);

    protected abstract void updateResume(int index, Resume r);

    protected abstract Resume getObjectByIndex(int index);
}
