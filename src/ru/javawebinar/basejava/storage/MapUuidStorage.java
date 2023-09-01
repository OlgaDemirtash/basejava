package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected List<Resume> doGetAll() {
        Resume[] storageArray = storage.values().toArray(new Resume[0]);
        return Arrays.asList(Arrays.copyOfRange(storageArray, 0, storageArray.length));
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.replace((String) searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    public boolean isExist(Object searchKey) {
        return storage.containsKey((String) searchKey);
    }
}

