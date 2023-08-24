package ru.javawebinar.basejava.storage;

import org.junit.Ignore;
import org.junit.Test;

public class MapFullNameStorageTest extends AbstractStorageTest {

    public MapFullNameStorageTest() {
        super(new MapFullNameStorage());
    }

    @Test
    @Ignore
    public void saveStorageOverflow() {
    }
}