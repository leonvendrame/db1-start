package com.db1.db1start;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }

    public static Integer sub(Integer number1, Integer number2) {
        return number1 - number2;
    }

    public static void upper(String message) {
        System.out.println(message.toUpperCase());
    }

    public static void lower(String message) {
        System.out.println(message.toLowerCase());
    }

    public static Double min(List<Double> numbers) {
        Double min = numbers.get(0);
        for (Double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[] readInteger = new Integer[2];
        String readMessage;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.printf("Insira um número: ");
            readInteger[i] = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println(sum(readInteger[0], readInteger[1]));
        System.out.println(sub(readInteger[0], readInteger[1]));

        System.out.printf("Insira uma mensagem: ");
        readMessage = scanner.nextLine();
        upper(readMessage);
        lower(readMessage);

        System.out.println(min(List.of(9.9, -34.4, -43.4)));
    }

}