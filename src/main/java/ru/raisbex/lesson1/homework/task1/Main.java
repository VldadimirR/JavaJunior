package ru.raisbex.lesson1.homework.task1;

import java.util.OptionalDouble;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

public class Main {
    public static void main(String[] args) {
        OptionalDouble result = Stream.of(3,4,1,2,5,2,7,8)
                .filter(numb -> numb % 2 == 0)
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Среднее значение: " + result);

    }

}
