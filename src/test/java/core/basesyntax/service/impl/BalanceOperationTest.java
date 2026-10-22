package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalanceOperationTest {
    @Test
    public void balanceOperationTest() {
        Storage storage = new Storage();
        BalanceOperation balanceOperation = new BalanceOperation(storage);
        balanceOperation.apply("apple", 10);
        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }

    @Test
    public void moreBalanceOperationTest() {
        Storage storage = new Storage();
        BalanceOperation balanceOperation = new BalanceOperation(storage);
        balanceOperation.apply("apple", 10);
        balanceOperation.apply("apple", 5);
        Assertions.assertEquals(5, storage.getAll().get("apple"));
    }
}
