package com.db1.db1start;

import javax.xml.stream.XMLInputFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SetHelper {

    public Set<String> namesSetGenerator() {
        return new HashSet<String>(Arrays.asList("Ronaldo", "Suzana",
                "Maria", "Joana", "Kaio", "Maria", "José", "Lucas",
                "Maria", "Robson", "Leonardo", "Maria", "Pedro"));
    }

    public void removeNames(Set<String> names) {
        names.removeAll(names);
    }

    public boolean hasSuzana(Set<String> names) {
        Optional<String> isSuzana = names.stream()
                .filter(string -> string.equals("Suzana"))
                .findFirst();
        if (isSuzana.isPresent()) {
            System.out.println("Suzana".toUpperCase());
            return true;
        }
        return false;
    }

    public void minMaxSumAverage(Set<Integer> set) {
        Integer sum = 0, min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        for (Integer number : set) {
            max = number > max ? number : max;
            min = number < min ? number : min;
            sum += number;
        }

        System.out.println("Menor Valor: " + min);
        System.out.println("Maior Valor: " + max);
        System.out.println("Soma: " + sum);
        System.out.println("Média: " + sum / set.size());
    }

}
