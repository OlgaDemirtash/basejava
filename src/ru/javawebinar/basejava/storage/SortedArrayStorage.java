package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    public void insertResume(Resume r) {

        int index = (Integer) getSearchKey(r.getUuid());
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;
    }

    @Override
    public void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid,"");
////        return Arrays.binarySearch(storage, 0, size, searchKey);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}