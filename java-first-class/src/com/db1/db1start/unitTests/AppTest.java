package com.db1.db1start.unitTests;

import com.db1.db1start.Application;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    Application application = new Application();

    @Test
    public void sumExpect5() {
        Integer expectedResult = 5;
        Integer response = application.sum(2, 3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void sumExpect0() {
        Integer expectedResult = 0;
        Integer response = application.sum(-1, 1);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void subtractExpect0() {
        Integer expectedResult = 0;
        Integer response = application.subtract(9, 9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void subtractExpectMinus1() {
        Integer expectedResult = -1;
        Integer response = application.subtract(1, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect0() {
        Integer expectedResult = 0;
        Integer response = application.divide(9, 0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect2() {
        Integer expectedResult = 2;
        Integer response = application.divide(4, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpect36() {
        Integer expectedResult = 36;
        Integer response = application.multiply(6, 6);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpect0() {
        Integer expectedResult = 0;
        Integer response = application.multiply(0, 4);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpectMinus5() {
        Integer expectedResult = -5;
        Integer response = application.multiply(5, -1);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect1() {
        Integer expectedResult = 1;
        Integer response = application.divide(3, 3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void isEvenExpectFalse() {
        boolean expectedResult = false;
        boolean response = application.isEven(9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void isEvenExpectTrue() {
        boolean expectedResult = true;
        boolean response = application.isEven(4);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpect43() {
        Integer expectedResult = 43;
        Integer response = application.max(32, 43);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpect0() {
        Integer expectedResult = 0;
        Integer response = application.max(0, -2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpectMinus3() {
        Integer expectedResult = -3;
        Integer response = application.max(-4, -3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyOddsToExpect5Even() {
        Integer expectedResult = 5;
        Integer response = application.howManyOddsTo(10);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyOddsToExpect5Odd() {
        Integer expectedResult = 5;
        Integer response = application.howManyOddsTo(9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyOddsToExpect2() {
        Integer expectedResult = 2;
        Integer response = application.howManyOddsTo(3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void vowelCountExpect5() {
        Integer expectedResult = 5;
        Integer response = application.vowelCount("a e iou");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void vowelCountExpect0() {
        Integer expectedResult = 0;
        Integer response = application.vowelCount("bcdfghjklmnpqrstvwxyz ");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void toUpperCaseExpectABC() {
        String expectedResult = "ABC";
        String response = application.toUpperCase("abc");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void toLowerCaseExpectAbc() {
        String expectedResult = "abc";
        String response = application.toLowerCase("ABC");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void first4LettersExpectMari() {
        String expectedResult = "Mari";
        String response = application.first4Letters("Maria Lobos");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void from3LetterExpectOnardo() {
        String expectedResult = "onardo Vendrame";
        String response = application.from3Letter("Leonardo Vendrame");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void last4LettersExpectIana() {
        String expectedResult = "iana";
        String response = application.last4Letters("Mariana Lália");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void changeFirstNameExpectAlunoa() {
        String expectedResult = "Aluno(a) da Silva";
        String response = application.changeFirstName("João da Silva");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void commaSpaceSplitExpectBananaMacaMelancia() {
        String[] expectedResult = {"banana", "maçã", "melância"};
        String[] response = application.commaSpaceSplit("banana, maçã, melância");
        Assert.assertArrayEquals(expectedResult, response);
    }

    @Test
    public void reverseStringExpectCba() {
        String expectedResult = "cba";
        String response = application.reverseString("abc");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyLettersExpect7() {
        Integer expectedResult = 7;
        Integer response = application.howManyLetters("  DB1 START  ");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void simpleAverageExpect10() {
        Double expectedResult = 10.0;
        Double response = application.simpleAverage(10.0, 20.0, 0.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void minDoubleExpectMinus3() {
        Double expectedResult = -3.0;
        Double response = application.minDouble(-3.0, 0.0, 2.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void minDoubleExpect0() {
        Double expectedResult = 0.0;
        Double response = application.minDouble(0.0, 2.0, 3.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void areaOfTriangleExpect4() {
        Double expectedResult = 4.0;
        Double response = application.areaOfTriangle(2.0,4.0);
        Assert.assertEquals(expectedResult, response);
    }
}
