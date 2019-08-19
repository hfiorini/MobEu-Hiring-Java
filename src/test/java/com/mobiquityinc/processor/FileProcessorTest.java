package com.mobiquityinc.processor;

import com.mobiquityinc.model.TextLine;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileProcessorTest {


    @Test
    public void givenAFilePathWhenIReadTheFileThenIGetOneRecordPerLine() throws IOException {
        List<TextLine> lines = FileProcessor.init("src/test/resources/test.txt");
        assertEquals(lines.size(),2);
    }

    @Test
    public void givenAFilePathWhenIReadTheFileThenIGetTheRightWeightPerLine() throws IOException {
        List<TextLine> lines = FileProcessor.init("src/test/resources/test.txt");
        assertEquals(lines.get(0).getMaxWeight(), new BigDecimal(81));
        assertEquals(lines.get(1).getMaxWeight(), new BigDecimal(8));

    }

    @Test
    public void givenAFilePathWhenIReadTheFileThenIGetTheRightItemsSizePerLine() throws IOException {
        List<TextLine> lines = FileProcessor.init("src/test/resources/test.txt");
        assertEquals(lines.get(0).getItems().size(), 3);
        assertEquals(lines.get(1).getItems().size(), 1);


    }

    @Test
    public void givenAFilePathWhenIReadTheFileThenIGetTheRightAttributesPerItem() throws IOException {
        List<TextLine> lines = FileProcessor.init("src/test/resources/test.txt");
        assertEquals(lines.get(0).getItems().get(0).getIndex(), 1);
        assertEquals(lines.get(0).getItems().get(0).getWeight(), new BigDecimal(53.38).setScale(2, RoundingMode.DOWN));
        assertEquals(lines.get(0).getItems().get(0).getCost(), new BigDecimal(45));

        assertEquals(lines.get(0).getItems().get(1).getIndex(), 2);
        assertEquals(lines.get(0).getItems().get(1).getWeight(), new BigDecimal(88.62).setScale(2, RoundingMode.DOWN));
        assertEquals(lines.get(0).getItems().get(1).getCost(), new BigDecimal(98));

        assertEquals(lines.get(0).getItems().get(2).getIndex(), 3);
        assertEquals(lines.get(0).getItems().get(2).getWeight(), new BigDecimal(78.48).setScale(2, RoundingMode.DOWN));
        assertEquals(lines.get(0).getItems().get(2).getCost(), new BigDecimal(3));

        assertEquals(lines.get(1).getItems().get(0).getIndex(), 1);
        assertEquals(lines.get(1).getItems().get(0).getWeight(), new BigDecimal(15.3).setScale(1, RoundingMode.DOWN));
        assertEquals(lines.get(1).getItems().get(0).getCost(), new BigDecimal(34));
    }

    @Test
    public void givenAWrongFilePathWhenIReadTheFileThenIGetException() {
        try {
            List<TextLine> lines = FileProcessor.init("src/test/resources/test_wrong.txt");
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
