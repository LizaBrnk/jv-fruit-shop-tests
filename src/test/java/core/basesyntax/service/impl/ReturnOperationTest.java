package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReturnOperationTest {
    @Test
    public void returnOperationTest() {
        Storage storage = new Storage();
        ReturnOperation returnOperation = new ReturnOperation(storage);
        returnOperation.apply("apple", 10);
        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }

    @Test
    public void moreReturnOperationTest() {
        Storage storage = new Storage();
        ReturnOperation returnOperation = new ReturnOperation(storage);
        returnOperation.apply("apple", 10);
        returnOperation.apply("apple", 5);
        Assertions.assertEquals(15, storage.getAll().get("apple"));
    }
}
