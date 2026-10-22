package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseOperationTest {
    @Test
    public void removeOperationTest() {
        Storage storage = new Storage();
        storage.add("apple", 15);
        PurchaseOperation purchaseOperation = new PurchaseOperation(storage);
        purchaseOperation.apply("apple", 10);
        Assertions.assertEquals(5, storage.getAll().get("apple"));
    }
}
