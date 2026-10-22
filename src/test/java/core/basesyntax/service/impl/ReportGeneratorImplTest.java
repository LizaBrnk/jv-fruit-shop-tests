package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportGeneratorImplTest {
    @Test
    public void reportGeneratorTest() {
        Storage storage = new Storage();
        storage.add("apple", 10);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();
        Assertions.assertEquals("fruit,quantity" + "\n" + "apple,10" + "\n", report);
    }

    @Test
    public void emptyStorageReportTest() {
        Storage storage = new Storage();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.getReport();
        Assertions.assertEquals("fruit,quantity" + "\n", report);
    }
}
