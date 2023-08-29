package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new HashMap<>();
    //Сравнение через Лямбда выражение
    //private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    //private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

//    private static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            int i =   o1.getUuid().compareTo(o2.getUuid());
//            if (i != 0) return i;
//            return o1.getFullName().compareTo(o2.getFullName());
//        }
//    };

//        private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> {
//            int i =   o1.getUuid().compareTo(o2.getUuid());
//            if (i != 0) return i;
//            return o1.getFullName().compareTo(o2.getFullName());
//        };

    //private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid).thenComparing(Resume::getFullName);


    //private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

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
        if (storage.containsKey(uuid)) {
            return storage.get(uuid);
        } else {
            return null;
        }
    }

    @Override
    protected void doSave(Resume r) {
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
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(searchKey)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isExist(Object searchKey) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(searchKey)) {
                return true;
            }
        }
        return false;
    }
}


