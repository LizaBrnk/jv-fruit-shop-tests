package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.read("src/main/resources/reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        ParserService dataConverter = new ParserServiceImpl();

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        Storage storage = new Storage();

        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage));

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        List<FruitTransaction> transactions = dataConverter.parse(inputReport);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        WriterForFile fileWriter = new WriterForFileImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
