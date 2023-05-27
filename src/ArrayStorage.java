import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int countResumes;

    void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
    }

    void save(Resume r) {
        if (r == null) {
            System.out.println("Ошибка сохранения резюме.Пустой объект.");
            return;
        }
        if (r.uuid == null) {
            System.out.println("Ошибка сохранения резюме.Не задан UUID.");
            return;
        }
        if (get(r.uuid) == null) {
            storage[countResumes] = r;
            countResumes++;
        } else {
            System.out.println("Ошибка сохранения.Резюме с таким UUID уже существует.");
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Ошибка при удалении. Резюме с таким UUID не найдено");
            return;
        }
        if (countResumes == 1) {
            clear();
            return;
        }
        System.arraycopy(storage, index + 1, storage, index, countResumes - index - 1);
        countResumes--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    int size() {
        return countResumes;
    }
}
