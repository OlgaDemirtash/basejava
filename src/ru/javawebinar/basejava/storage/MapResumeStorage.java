package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

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
            return storage.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

        storage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(doGet(searchKey).getUuid());
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.replace(doGet(searchKey).getUuid(), r);
    }

    protected List<Resume> doGetAll() {
        Resume[] storageArray = storage.values().toArray(new Resume[0]);
        return Arrays.asList(Arrays.copyOfRange(storageArray, 0, storageArray.length));
    }

    @Override
    protected Resume doGet(Object searchKey) {

        return (Resume) searchKey;
    }

    @Override
    public boolean isExist(Object searchKey) {

        return searchKey != null;
    }
}


