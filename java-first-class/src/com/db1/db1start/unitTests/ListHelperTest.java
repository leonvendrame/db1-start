package com.db1.db1start.unitTests;

import com.db1.db1start.ListHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListHelperTest {

    ListHelper listHelper = new ListHelper();

    @Test
    public void listSizeExpect3() {
        List<String> testList = new ArrayList<String>(Arrays.asList("1", "2", "3"));
        Integer expectedResult = 3;
        Integer result = listHelper.listSize(testList);
        Assert.assertEquals(expectedResult, result);
    }
}
