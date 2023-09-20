package ru.javawebinar.basejava.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Резюме с UUID " + uuid + " не найдено.", uuid);
    }
}