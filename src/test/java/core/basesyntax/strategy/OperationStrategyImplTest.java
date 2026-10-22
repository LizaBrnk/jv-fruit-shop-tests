package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.OperationHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationStrategyImplTest {
    @Test
    public void operationStrategyTest() {
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        Storage storage = new Storage();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));

        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.BALANCE);
        transaction.setFruit("apple");
        transaction.setQuantity(10);

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operations);
        operationStrategy.process(transaction);

        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }

    @Test
    public void noOperationStrategyHandlerTest() {
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();

        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.BALANCE);
        transaction.setFruit("apple");
        transaction.setQuantity(10);

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operations);

        Assertions.assertThrows(RuntimeException.class,
                () -> operationStrategy.process(transaction));
    }
}
