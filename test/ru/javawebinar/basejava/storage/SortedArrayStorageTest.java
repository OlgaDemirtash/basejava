package ru.javawebinar.basejava.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super();
        storage = new SortedArrayStorage();
    }
}