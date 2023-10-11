package com.example;

import java.util.Scanner;

/**
 * Grade calculator app
 *
 */
public class App {
    public static void main(String[] args) {
        Calculator c = new Calculator(new Scanner(System.in));
        c.askGrades();
        System.out.println(c.calculateAverage());
    }
}
