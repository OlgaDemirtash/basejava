package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ListStorage extends AbstractStorage {
    ArrayList<Resume> storage = new ArrayList<>();
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
    protected int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        return storage.indexOf(r);
    }

    @Override
    protected void insertResume(Resume r) {
        storage.add(r);
    }

    @Override
    protected void removeResume(int index) {
        storage.remove(index);
    }

    @Override
    protected Resume getObjectByIndex(int index) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(int index, Resume r) {
        storage.set(index,r);
    }
}