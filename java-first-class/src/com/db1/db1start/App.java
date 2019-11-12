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

    public static String upper(String message) {
        return  message.toUpperCase();
    }

    public static String lower(String message) {
        return message.toLowerCase();
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
        List<Double> doubles = new ArrayList<>();
        String readMessage;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; ++i) {
            System.out.printf("Insira um número inteiro: ");
            readInteger[i] = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("A soma entre eles é: " + sum(readInteger[0], readInteger[1]));
        System.out.println("A diferença entre eles é: " + sub(readInteger[0], readInteger[1]));

        System.out.printf("Insira uma mensagem: ");
        readMessage = scanner.nextLine();
        System.out.println("Sua mensagem maiúscula: " + upper(readMessage));
        System.out.println("Sua mensagem minúscula: " + lower(readMessage));

        for (int i = 0; i < 3; ++i) {
            System.out.printf("Insira um número real: ");
            doubles.add(scanner.nextDouble());
        }

        System.out.println("O menor entre eles é: " + min(doubles));

        scanner.close();
    }

}