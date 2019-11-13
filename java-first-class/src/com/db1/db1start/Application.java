package com.db1.db1start;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public Integer sum(Integer number1, Integer number2) {
        return (number1 + number2);
    }

    public Integer subtract(Integer number1, Integer number2) {
        return (number1 - number2);
    }

    public Integer multiply(Integer number1, Integer number2) {
        return (number1 * number2);
    }

    public Integer divide(Integer dividend, Integer divisor) {
        if (divisor != 0) {
            return (dividend / divisor);
        }
        return 0;
    }

    public boolean isEven(Integer number) {
        return (number % 2 == 0);
    }

    public Integer max(Integer number1, Integer number2) {
        if (number1 >= number2) {
            return number1;
        }
        return number2;
    }

    public Integer howManyOddsTo(Integer number) {
        return ((number / 2) + (number % 2));
    }

    public String toUpperCase(String string) {
        return string.toUpperCase();
    }

    public String toLowerCase(String string) {
        return string.toLowerCase();
    }

    public Integer howManyCharacters(String string) {
        return string.length();
    }

    public Integer howManyLetters(String string) {
        return  string.trim().replaceAll("[^a-zA-Z]", "").length();
    }

    public String first4Letters(String name) {
        return name.substring(0, 4);
    }

    public String from3Letter(String name) {
        return name.substring(2);
    }

    public String last4Letters(String name) {
        String nameOnly = name.split(" ")[0];
        return nameOnly.substring(nameOnly.length() - 4);
    }

    public String changeFirstName(String name) {
        String[] separatedNames = name.split(" ");
        StringBuilder response = new StringBuilder();
        separatedNames[0] = "Aluno(a)";

        for (int i = 0; i < separatedNames.length; ++i) {
            response.append(separatedNames[i]);

            if (i != separatedNames.length - 1) {
                response.append(" ");
            }
        }
        return response.toString();
    }

    public String[] commaSpaceSplit(String string) {
        return string.split(", ");
    }

    public Integer vowelCount(String string) {
        return string.toLowerCase().replaceAll("[^aeiou]", "").length();
    }

    public String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public Double minDouble(Double number1, Double number2) {
        return (number1 < number2 ? number1 : number2);
    }

    public Double minDouble(Double number1, Double number2, Double number3) {
        return (minDouble(minDouble(number1, number2), number3));
    }

    public Double simpleAverage(Double number1, Double number2, Double number3) {
        return ((number1 + number2 + number3) / 3);
    }

    public Double areaOfTriangle(Double base, Double height) {
        return ((base * height) / 2);
    }
}
