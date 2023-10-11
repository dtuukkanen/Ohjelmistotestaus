package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private Scanner scanner;
    private ArrayList<Integer> vec;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void askGrades() {
        vec = new ArrayList<>();
        int i = 1;
        int n = -1;

        // Text in the beginning
        System.out.println(
                "***\nThis program calculates average of school grades (4-10). Input number, press enter. Zero (0) ends the input.");

        // Loop for asking grades
        while (n != 0) {
            System.out.println(i + ": ");
            if (scanner.hasNext()) {
                // Check if input is a number
                try {
                    n = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }

                // Check if input is 0, end
                if (n == 0) {
                    break;
                    // Check if input is between 4 and 10, try again
                } else if (n < 4 || n > 10) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }
                vec.add(n);
                i++;
            }
        }

    }

    public float calculateAverage() {
        return divider(sum(vec), vec.size());
    }

    public float divider(int x, int y) {
        // System.out.println(x + " " + y);
        return x / (float) y;
    }

    public int sum(ArrayList<Integer> vec) {
        int s = 0;

        for (int i : vec) {
            s += i;
        }

        return s;
    }

    public ArrayList<Integer> getVec() {
        return vec;
    }

}
