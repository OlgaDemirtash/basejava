package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapStorage extends AbstractStorage {
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
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (String key : storage.keySet()) {
            if (Objects.equals(key, uuid)) {
                return key;
            }
        }
        return null;
    }

    @Override
    protected void aSave(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void aDelete(Object searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected void aUpdate(Resume r, Object searchKey) {
        storage.replace((String) searchKey, r);
    }

    @Override
    protected Resume aGet(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    public boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}

