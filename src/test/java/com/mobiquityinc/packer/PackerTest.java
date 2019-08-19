package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

public class PackerTest {

    @Test
    public void givenAWrongPathWhenParsingAFileThenIGetAnAPIException(){
        try {
            Packer.pack("src/test/resources/testPacker0.txt");
            Assert.fail();
        } catch (APIException e) {
            Assert.assertEquals(e.getMessage(), "src\\test\\resources\\testPacker0.txt (The system cannot find the file specified)");
        }
    }

    @Test
    public void testPacker2() throws APIException {
        String result = Packer.pack("src/test/resources/testPacker.txt");
        Assert.assertEquals(result, "4\n" +
                "-\n" +
                "2, 7\n" +
                "6, 9\n");

    }

    @Test
    public void testPacker1row() throws APIException {
        String result = Packer.pack("src/test/resources/testPacker1.txt");
        Assert.assertEquals(result, "4\n");

    }

    @Test
    public void testPacker2ndRow() throws APIException {
        String result = Packer.pack("src/test/resources/testPacker2.txt");
        Assert.assertEquals(result, "-\n");

    }

    @Test
    public void testPacker3rdRow() throws APIException {
        String result = Packer.pack("src/test/resources/testPacker3.txt");
        Assert.assertEquals(result, "2, 7\n");

    }

    @Test
    public void testPacker4thRow() throws APIException {
        String result = Packer.pack("src/test/resources/testPacker4.txt");
        Assert.assertEquals(result, "6, 9\n");

    }

    @Test
    public void testPackerEmpty() throws APIException {
        String result = Packer.pack("src/test/resources/testPackerEmpty.txt");
        Assert.assertEquals(result, "");
    }



}
