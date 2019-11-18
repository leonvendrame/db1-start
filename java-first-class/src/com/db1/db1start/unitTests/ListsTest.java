package com.db1.db1start.unitTests;

import com.db1.db1start.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsTest {

    Lists lists = new Lists();

    @Test
    public void listSizeExpect3() {
        List<String> testList = new ArrayList<String>(Arrays.asList("1", "2", "3"));
        Integer expectedResult = 3;
        Integer result = lists.listSize(testList);
        Assert.assertEquals(expectedResult, result);
    }
}
