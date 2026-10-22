package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserServiceImplTest {
    @Test
    public void lineInParserTest() {
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<String> parseTest = new ArrayList<>();
        parseTest.add("type,fruit,quantity");
        parseTest.add("b,apple,10");
        List<FruitTransaction> transactions = parserService.parse(parseTest);
        Assertions.assertEquals(10, transactions.get(0).getQuantity());
    }

    @Test
    public void nameInParserTest() {
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<String> parseTest = new ArrayList<>();
        parseTest.add("type,fruit,quantity");
        parseTest.add("b,apple,10");
        List<FruitTransaction> transactions = parserService.parse(parseTest);
        Assertions.assertEquals("apple", transactions.get(0).getFruit());
    }

    @Test
    public void operationInParserTest() {
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<String> parseTest = new ArrayList<>();
        parseTest.add("type,fruit,quantity");
        parseTest.add("b,apple,10");
        List<FruitTransaction> transactions = parserService.parse(parseTest);
        Assertions.assertEquals(FruitTransaction.Operation.BALANCE,
                transactions.get(0).getOperation());
    }

    @Test
    public void unknownOperationTest() {
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<String> parseTest = new ArrayList<>();
        parseTest.add("type,fruit,quantity");
        parseTest.add("x,apple,10");
        Assertions.assertThrows(RuntimeException.class, () -> parserService.parse(parseTest));
    }

    @Test
    public void invalidCsvFormatTest() {
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<String> parseTest = new ArrayList<>();
        parseTest.add("type,fruit,quantity");
        parseTest.add("b,apple");
        Assertions.assertThrows(RuntimeException.class, () -> parserService.parse(parseTest));
    }
}
