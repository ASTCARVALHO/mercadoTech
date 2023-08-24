package br.ufpb.dcx.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Type the position of the fibonacci number: ");
        int pos = input.nextInt();

        System.out.printf("The fibonacci number of the %sth position is %s\n", (pos + 1), fibonacciRecursive(pos));
    }

    public static int fibonacciFor(int pos) {
        if (pos == 0 || pos == 1) {
            return pos;
        }
        int first = 0, last = 1;
        int next = 0;
        for (int i = 2; i <= pos; i++) {
            next = first + last;
            first = last;
            last = next;
        }
        return next;
    }

    public static int fibonacciWhile(int pos) {
        if (pos == 0 || pos == 1) {
            return pos;
        }
        int first = 0, last = 1;
        int next = 0, i = 2;
        while (i <= pos) {
            next = first + last;
            first = last;
            last = next;
            i++;
        }
        return next;
    }

    public static int fibonacciRecursive(int pos) {
        if (pos == 0 || pos == 1) {
            return pos;
        }
        return fibonacciRecursive(pos - 1) + fibonacciRecursive(pos - 2);
    }

}
