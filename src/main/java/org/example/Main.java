package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stat number: ");
        int startNumber = scanner.nextInt();
        System.out.print("Enter last number: ");
        int lastNumber = scanner.nextInt();
        int[] array = createArray(startNumber, lastNumber);
        System.err.println("Your guessed number is : " + bubbleSearch(array, 3));
    }

    public static int bubbleSearch(int[] array, int n) {

        Scanner scanner = new Scanner(System.in);
        int mid = 0;
        n = guessStep(array.length);
        System.out.println("I can find your guessed number max in " + n + " steps");
        //   midIndex = (int) Math.round((double) array.length / 2 - 1);
        mid = array.length / 2;

        System.out.println("1) The number you guessed is equal " + array[mid] + "?");
        System.out.println("2) Is the number you guessed greater than " + array[mid] + "?");
        System.out.println("3) Is the number you guessed less than " + array[mid] + "?");
        int scanResult = scanner.nextInt();
        if (n == 1 && scanResult == 1) {
            return array[mid-1];
        } else if (scanResult == 2) {
            array = Arrays.copyOfRange(array, mid + 1, array.length);
            return bubbleSearch(array, n - 1);
        } else if (scanResult == 3) {
            array = Arrays.copyOfRange(array, 0, mid);
            return bubbleSearch(array, n - 1);
        }
        return -10;
    }

    public static int guessStep(int arrayLength) {
        return (int) (Math.round(Math.log(arrayLength) / Math.log(2)));
    }

    public static int[] createArray(int firstNumber, int secondNumber) {

        int[] array = new int[secondNumber - firstNumber + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = firstNumber++;
        }
        return array;
    }
}

