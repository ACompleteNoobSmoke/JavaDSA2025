package org.recursion;

public class RecursionMain {


    private static String reverse(String word) {
        if (word == null || word.isBlank()) return " ";
        return reverse(word.substring(1)) + word.charAt(0);
    }

    public static void main(String[] args) {
        String word = "Eminem";
//        System.out.println(1 / 2);
//        System.out.print(decimalToBinary(233));
//        System.out.println(sumNaturalNumbers(10));
        System.out.println(squareRoot(8));
    }

    private static int decimalToBinary(int decimal) {
        if (decimal == 0) return 0;
        System.out.print((decimal % 2) + " ");
        return decimalToBinary(decimal / 2);
    }

    private static int sumNaturalNumbers(int n) {
        if (n == 1) return 1;
        return sumNaturalNumbers(n - 1) + n;
    }

    private static int squareRoot(int n) {
        if (n == 1) return n;
        if (n % 2 == 0) return n;
        return squareRoot(n - 1);
    }
}
