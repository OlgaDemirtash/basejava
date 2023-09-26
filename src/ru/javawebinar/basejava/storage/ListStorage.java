package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage<Integer> {

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
    public List<Resume> getAllSorted() {
        return storage;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storage.set((int) searchKey, r);
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {

        storage.add(r);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove((int) searchKey);
    }

    @Override
    protected List<Resume> doGetAll() {
        return storage;
    }

    @Override
    public boolean isExist(Integer searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage);
    }
}