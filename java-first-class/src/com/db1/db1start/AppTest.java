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
    public void subExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.sub(9, 9);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void sumExpectMinus1() {
        Application application = new Application();
        Integer expectedResult = -1;
        Integer response = application.sub(1, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.div(9, 0);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divExpect2() {
        Application application = new Application();
        Integer expectedResult = 2;
        Integer response = application.div(4, 2);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void mulExpect36() {
        Application application = new Application();
        Integer expectedResult = 36;
        Integer response = application.mul(6, 6);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void mulExpect0() {
        Application application = new Application();
        Integer expectedResult = 0;
        Integer response = application.mul(0, 4);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void mulExpectMinus5() {
        Application application = new Application();
        Integer expectedResult = -5;
        Integer response = application.mul(5, -1);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void divExpect1() {
        Application application = new Application();
        Integer expectedResult = 1;
        Integer response = application.div(3, 3);
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
    public void howMuchOddsToExpect5() {
        Application application = new Application();
        Integer expectedResult = 5;
        Integer response = application.howMuchOddsTo(10);
        Assert.assertEquals(expectedResult, response);
    }

    @Test
    public void howMuchOddsToExpect2() {
        Application application = new Application();
        Integer expectedResult = 2;
        Integer response = application.howMuchOddsTo(3);
        Assert.assertEquals(expectedResult, response);
    }


}
