package org.example;

import java.util.Scanner;

public class UserInput {
    public static int[] askForInput(Scanner scanner) {

        System.out.println("Enter row (1 - 10): ");
        int x = scanner.nextInt() - 1;

        System.out.println("Enter column (1 - 10): ");
        int y = scanner.nextInt() - 1;

        return new int[]{x, y};
    }
}