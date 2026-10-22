package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupplyOperationTest {
    @Test
    public void supplyOperationTest() {
        Storage storage = new Storage();
        SupplyOperation supplyOperation = new SupplyOperation(storage);
        supplyOperation.apply("apple", 10);
        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }

    @Test
    public void moreSupplyOperationTest() {
        Storage storage = new Storage();
        SupplyOperation supplyOperation = new SupplyOperation(storage);
        supplyOperation.apply("apple", 10);
        supplyOperation.apply("apple", 5);
        Assertions.assertEquals(15, storage.getAll().get("apple"));
    }
}
