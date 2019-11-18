package com.db1.db1start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Lists listsExample = new Lists();

        List<String> favoriteColorsList = listsExample.favoriteColors();
        List<String> testString = new ArrayList<>();

        listsExample.removeColorFromList(favoriteColorsList, "Azul");
        listsExample.removeColorFromList(favoriteColorsList, "Preto");

        testString = listsExample.stringsToList("Teste 0", "Teste 1", "Teste 2");
        System.out.println(listsExample.listSize(testString));
        printSeparator();

        listsExample.printFavoriteColorsList();
        printSeparator();

        listsExample.printFavoriteColorsOrderByName();
        printSeparator();

        listsExample.printListReverseOrderByName(favoriteColorsList);
        printSeparator();

        System.out.println(listsExample.mapOddsEvens(Arrays.asList(2, 3, 4, 5)));


    }


    public static void printSeparator() {
        System.out.println("------------------------");
    }

}