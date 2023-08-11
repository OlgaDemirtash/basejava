package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();
    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return storage.indexOf(r);}
        }
        return -1;
    }
    @Override
    protected void aUpdate(Resume r, Object searchKey) {
        storage.set((int) searchKey, r);
    }

    @Override
    protected void aSave(Resume r) {
        storage.add(r);
    }

    @Override
    protected Resume aGet(Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void aDelete(Object searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    public boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }
}