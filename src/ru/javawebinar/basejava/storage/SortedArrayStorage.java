package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r) {
        int index = getIndex(r.getUuid());
        index = Math.abs(index + 1);
        System.arraycopy(storage, index, storage, index + 1, size - index + 1);
        storage[index] = r;
    }

    public void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}