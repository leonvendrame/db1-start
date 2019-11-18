package com.db1.db1start;

import java.util.*;

public class ListHelper {

    public List<String> favoriteColors() {
        List<String> favoriteColors = new ArrayList<>();
        favoriteColors.addAll(Arrays.asList("Branco", "Preto", "Cinza",
                "Azul", "Vermelho", "Verde"));
        return favoriteColors;
    }

    public Integer listSize(List list) {
        return list.size();
    }

    public List<String> stringsToList(String string1, String string2, String string3) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(string1, string2, string3));
        list.remove(1);
        return list;
    }

    public void printFavoriteColorsList() {
        List<String> favoriteColors = this.favoriteColors();
        System.out.println("Cores favoritas: ");
        favoriteColors.forEach(color -> {
            System.out.println(color);
        });
    }

    public void printFavoriteColorsOrderByName() {
        List<String> favoriteColors = this.favoriteColors();
        favoriteColors.sort(Comparator.naturalOrder());
        favoriteColors.forEach(color -> {
            System.out.println(color);
        });
    }

    public void printListReverseOrderByName(List<String> favoriteColors) {
        favoriteColors.sort(Comparator.reverseOrder());
        favoriteColors.forEach(color -> {
            System.out.println(color);
        });
    }

    public void removeColorFromList(List colorsList, String color) {
        colorsList.removeAll(Arrays.asList(color));
    }

    public Map mapOddsEvens(List<Integer> numbersList) {
        Map<String, List<Integer>> mapOddsEvens = new HashMap<>();
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        numbersList.forEach(number -> {
            if (number % 2 == 0) {
                evens.add(number);
            } else {
                odds.add(number);
            }
        });

        mapOddsEvens.put("Par", evens);
        mapOddsEvens.put("Impar", odds);

        return mapOddsEvens;
    }
}