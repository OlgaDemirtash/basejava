package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Сохранение невозможно.Хранилище переполнено.");
        }
        int index = getIndex(r.getUuid());
        if (index > -1) {
            System.out.println("Ошибка сохранения.Резюме с UUID" + r.getUuid() + "уже существует.");
        } else {
            index = Math.abs(index + 1) ;
            System.arraycopy(storage, index, storage, index + 1, size - index + 1);
            storage[index] = r;
            size++;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}