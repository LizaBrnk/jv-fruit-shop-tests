package core.basesyntax.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    public void addFruitsTest() {
        Storage storage = new Storage();
        storage.add("apple", 10);
        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }

    @Test
    public void addMoreFruitsTest() {
        Storage storage = new Storage();
        storage.add("apple", 10);
        storage.add("apple", 5);
        Assertions.assertEquals(15, storage.getAll().get("apple"));
    }

    @Test
    public void setFruitsTest() {
        Storage storage = new Storage();
        storage.add("apple", 10);
        storage.set("apple", 3);
        Assertions.assertEquals(3, storage.getAll().get("apple"));
    }

    @Test
    public void removeFruitsTest() {
        Storage storage = new Storage();
        storage.add("apple", 10);
        storage.remove("apple", 4);
        Assertions.assertEquals(6, storage.getAll().get("apple"));
    }

    @Test
    public void removeMoreThanAvailableTest() {
        Storage storage = new Storage();
        storage.add("apple", 5);
        Assertions.assertThrows(RuntimeException.class, () -> storage.remove("apple", 8));
    }
}
