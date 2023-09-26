package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

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
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, String searchKey) {

        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(String searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected List<Resume> doGetAll() {
        Resume[] storageArray = storage.values().toArray(new Resume[0]);
        return Arrays.asList(Arrays.copyOfRange(storageArray, 0, storageArray.length));
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        storage.replace((String) searchKey, r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}

