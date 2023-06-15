package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Ошибка при изменении. Резюме с UUID " + r.getUuid() + " не найдено.");
        } else {
            storage[index] = r;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        }
        return storage[index];
    }

    public final void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Сохранение невозможно.Хранилище переполнено.");
        } else if (getIndex(r.getUuid()) > -1) {
            System.out.println("Ошибка сохранения.Резюме с UUID" + r.getUuid() + "уже существует.");
        } else {
            insertResume(r);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Ошибка при удалении. Резюме с UUID" + uuid + "не найдено.");
            return;
        }
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void insertResume(Resume r);

    protected abstract void removeResume(int index);

    protected abstract int getIndex(String uuid);

}