package com.db1.db1start;

import java.util.*;

public class App {

    public static void main(String[] args) {
        SetHelper setHelper = new SetHelper();

        System.out.println(setHelper.namesSetGenerator());
        setHelper.minMaxSumAverage(new HashSet<>(Arrays.asList(1, 2, 3, 5)));
        System.out.println(setHelper.hasSuzana(setHelper.namesSetGenerator()));

    }


    public static void printSeparator() {
        System.out.println("------------------------");
    }

}