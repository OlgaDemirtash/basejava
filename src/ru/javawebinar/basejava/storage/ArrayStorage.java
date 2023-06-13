package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Сохранение невозможно.Хранилище переполнено.");
        } else if (getIndex(r.getUuid()) != -1) {
            System.out.println("Ошибка сохранения.Резюме с UUID" + r.getUuid() + "уже существует.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
