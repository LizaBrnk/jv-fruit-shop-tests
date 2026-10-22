package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopServiceImplTest {
    @Test
    public void shopServiceTest() {
        Storage storage = new Storage();
        Map<FruitTransaction.Operation, OperationHandler> params = new HashMap<>();
        params.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));

        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.BALANCE);
        transaction.setFruit("apple");
        transaction.setQuantity(10);

        List<FruitTransaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(params);
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
        Assertions.assertEquals(10, storage.getAll().get("apple"));
    }
}
