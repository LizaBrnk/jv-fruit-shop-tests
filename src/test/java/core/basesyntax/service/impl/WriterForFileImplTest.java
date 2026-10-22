package core.basesyntax.service.impl;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WriterForFileImplTest {
    @Test
    public void writeFile() {
        WriterForFileImpl writer = new WriterForFileImpl();
        writer.write("Hello, World!", "src/test/resources/finalReportTest.csv");
        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<String> lines = reader.read("src/test/resources/finalReportTest.csv");
        Assertions.assertEquals("Hello, World!", lines.get(0));
    }

    @Test
    public void writeToInvalidPathTest() {
        WriterForFileImpl writer = new WriterForFileImpl();
        Assertions.assertThrows(RuntimeException.class,
                () -> writer.write("Hello, World!", "src/test/missing-folder/file.csv"));
    }
}
