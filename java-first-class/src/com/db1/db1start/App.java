package com.db1.db1start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ListHelper listHelperExample = new ListHelper();

        List<String> favoriteColorsList = listHelperExample.favoriteColors();
        List<String> testString = new ArrayList<>();

        listHelperExample.removeColorFromList(favoriteColorsList, "Azul");
        listHelperExample.removeColorFromList(favoriteColorsList, "Preto");

        testString = listHelperExample.stringsToList("Teste 0", "Teste 1", "Teste 2");
        System.out.println(listHelperExample.listSize(testString));
        printSeparator();

        listHelperExample.printFavoriteColorsList();
        printSeparator();

        listHelperExample.printFavoriteColorsOrderByName();
        printSeparator();

        listHelperExample.printListReverseOrderByName(favoriteColorsList);
        printSeparator();

        System.out.println(listHelperExample.mapOddsEvens(Arrays.asList(2, 3, 4, 5)));

    }


    public static void printSeparator() {
        System.out.println("------------------------");
    }

}