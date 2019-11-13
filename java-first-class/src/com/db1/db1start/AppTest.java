package com.db1.db1start;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void sumExpect5() {
        Application application = new Application();
        Integer expectedResult = 5;
        Integer response = application.sum(2, 3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void sumExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.sum(-1, 1);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void subtractExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.subtract(9, 9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void subtractExpectMinus1() {
        Application application = new Application();
        Integer expectedResult = -1;
        Integer response = application.subtract(1, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.divide(9, 0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect2() {
        Application application = new Application();
        Integer expectedResult = 2;
        Integer response = application.divide(4, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpect36() {
        Application application = new Application();
        Integer expectedResult = 36;
        Integer response = application.multiply(6, 6);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.multiply(0, 4);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void multiplyExpectMinus5() {
        Application application = new Application();
        Integer expectedResult = -5;
        Integer response = application.multiply(5, -1);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divideExpect1() {
        Application application = new Application();
        Integer expectedResult = 1;
        Integer response = application.divide(3, 3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void isEvenExpectFalse() {
        Application application = new Application();
        boolean expectedResult = false;
        boolean response = application.isEven(9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void isEvenExpectTrue() {
        Application application = new Application();
        boolean expectedResult = true;
        boolean response = application.isEven(4);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpect43() {
        Application application = new Application();
        Integer expectedResult = 43;
        Integer response = application.max(32, 43);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.max(0, -2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void maxExpectMinus3() {
        Application application = new Application();
        Integer expectedResult = -3;
        Integer response = application.max(-4, -3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyOddsToExpect5() {
        Application application = new Application();
        Integer expectedResult = 5;
        Integer response = application.howManyOddsTo(10);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyOddsToExpect2() {
        Application application = new Application();
        Integer expectedResult = 2;
        Integer response = application.howManyOddsTo(3);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void vowelCountExpect5() {
        Application application = new Application();
        Integer expectedResult = 5;
        Integer response = application.vowelCount("a e iou");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void vowelCountExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.vowelCount("bcdfghjklmnpqrstvwxyz ");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void toUpperCaseExpectABC() {
        Application application = new Application();
        String expectedResult = "ABC";
        String response = application.toUpperCase("abc");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void toLowerCaseExpectAbc() {
        Application application = new Application();
        String expectedResult = "abc";
        String response = application.toLowerCase("ABC");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void first4LettersExpectMari() {
        Application application = new Application();
        String expectedResult = "Mari";
        String response = application.first4Letters("Maria Lobos");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void from3LetterExpectOnardo() {
        Application application = new Application();
        String expectedResult = "onardo Vendrame";
        String response = application.from3Letter("Leonardo Vendrame");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void last4LettersExpectIana() {
        Application application = new Application();
        String expectedResult = "iana";
        String response = application.last4Letters("Mariana Lália");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void changeFirstNameExpectAlunoa() {
        Application application = new Application();
        String expectedResult = "Aluno(a) da Silva";
        String response = application.changeFirstName("João da Silva");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void commaSpaceSplitExpectBananaMacaMelancia() {
        Application application = new Application();
        String[] expectedResult = {"banana", "maçã", "melância"};
        String[] response = application.commaSpaceSplit("banana, maçã, melância");
        Assert.assertArrayEquals(expectedResult, response);
    }

    @Test
    public void reverseStringExpectCba() {
        Application application = new Application();
        String expectedResult = "cba";
        String response = application.reverseString("abc");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howManyLettersExpect7() {
        Application application = new Application();
        Integer expectedResult = 7;
        Integer response = application.howManyLetters("  DB1 START  ");
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void simpleAverageExpect10() {
        Application application = new Application();
        Double expectedResult = 10.0;
        Double response = application.simpleAverage(10.0, 20.0, 0.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void minDoubleExpectMinus3() {
        Application application = new Application();
        Double expectedResult = -3.0;
        Double response = application.minDouble(-3.0, 0.0, 2.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void minDoubleExpect0() {
        Application application = new Application();
        Double expectedResult = 0.0;
        Double response = application.minDouble(0.0, 2.0, 3.0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void areaOfTriangleExpect4() {
        Application application = new Application();
        Double expectedResult = 4.0;
        Double response = application.areaOfTriangle(2.0,4.0);
        Assert.assertEquals(expectedResult, response);
    }

}
