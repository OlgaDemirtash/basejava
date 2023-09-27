package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File nextFile : files) {
                try {
                    doDelete(nextFile);
                } catch (SecurityException e) {
                    throw new StorageException("Delete file error", nextFile.getName(), e);
                }
            }
        } else {
            throw new StorageException("Directory is empty", directory.getName());
        }
    }

    @Override
    public int size() {
        String[] files = directory.list();
        if (files != null) {
            return files.length;
        } else {
            throw new StorageException("Directory is empty", directory.getName());
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        try {
            if (!file.delete()) {
                throw new StorageException("File was not deleted", file.getName());
            }
        } catch (SecurityException e) {
            throw new StorageException("Delete file error", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();
        List<Resume> resumes = new ArrayList<>();
        if (files != null) {
            for (File nextFile : files) {
                try {
                    resumes.add(doRead(nextFile));
                } catch (IOException e) {
                    throw new StorageException("IO error", nextFile.getName(), e);
                }
            }
        } else {
            throw new StorageException("Directory is empty", directory.getName());
        }
        return resumes;
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;
}
