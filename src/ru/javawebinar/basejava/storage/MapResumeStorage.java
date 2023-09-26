package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {

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
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {

        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume searchKey) {
        storage.remove(doGet(searchKey).getUuid());
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        storage.replace(doGet(searchKey).getUuid(), r);
    }

    protected List<Resume> doGetAll() {
        Resume[] storageArray = storage.values().toArray(new Resume[0]);
        return Arrays.asList(Arrays.copyOfRange(storageArray, 0, storageArray.length));
    }

    @Override
    protected Resume doGet(Resume searchKey) {

        return (Resume) searchKey;
    }

    @Override
    public boolean isExist(Resume searchKey) {

        return searchKey != null;
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}


