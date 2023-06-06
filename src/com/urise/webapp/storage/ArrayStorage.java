package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (r == null) {
            System.out.println("Ошибка при изменении резюме.Пустой объект.");
            return;
        }
        int index = getResumeIndex(r.uuid);
        if (index == -1) {
            System.out.printf("Ошибка при изменении. Резюме с UUID %s не найдено.\n", r.uuid);
            return;
        }
        storage[index] = r;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Сохранение невозможно.Хранилище переполнено.");
            return;
        }
        if (r == null) {
            System.out.println("Ошибка сохранения резюме.Пустой объект.");
            return;
        }
        if (r.uuid == null) {
            System.out.println("Ошибка сохранения резюме.Не задан UUID.");
            return;
        }
        if (get(r.uuid) == null) {
            storage[size] = r;
            size++;
        } else {
            System.out.printf("Ошибка сохранения.Резюме с UUID %s уже существует.\n", r.uuid);
        }
    }

    public Resume get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            System.out.printf("Ошибка при удалении. Резюме с UUID %s не найдено.\n", uuid);
            return;
        }
        if (size == 1) {
            clear();
            return;
        }
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        //System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getResumeIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
