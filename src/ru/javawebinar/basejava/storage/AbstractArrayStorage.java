package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage;
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
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected void doSave(Resume r, Integer index) {

        if (size == storage.length) {
            throw new StorageException("Хранилище переполнено", r.getUuid());
        } else {
            insertResume(r, index);
            size++;
        }
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected void doDelete(Integer index) {
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.stream(Arrays.copyOf(storage, size)).collect(Collectors.toList());
    }

    protected abstract void insertResume(Resume r, Integer index);

    protected abstract void removeResume(Integer index);

    protected abstract Integer getSearchKey(String uuid);

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }
}