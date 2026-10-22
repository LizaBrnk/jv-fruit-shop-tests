package core.basesyntax.service.impl;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReaderServiceImplTest {
    @Test
    public void readFileTest() {
        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<String> lines = reader.read("src/test/resources/reportToReadTest.csv");
        Assertions.assertEquals(3, lines.size());
        Assertions.assertEquals("b,apple,10", lines.get(1));
    }

    @Test
    public void readNonExistingFileTest() {
        ReaderServiceImpl reader = new ReaderServiceImpl();
        Assertions.assertThrows(RuntimeException.class,
                () -> reader.read("src/test/resources/missingFile.csv"));
    }
}
