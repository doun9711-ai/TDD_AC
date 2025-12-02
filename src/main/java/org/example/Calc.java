package org.example;

public class Calc {

    public static int run(String exp) {

        exp = exp.replace("- ", "+ -");

        boolean needToPlus = exp.contains("+");
        boolean needToMultiply = exp.contains("*");
        boolean needToCompond = needToPlus && needToMultiply;

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        }
        if (needToMultiply) {
            bits = exp.split(" \\* ");
        }
        if (needToCompond) {
            bits =exp.split(" \\+ ");

            return Integer.parseInt(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
        }


        int sum = 0;
        for (int i = 0; i < bits.length; i++) {
            sum = sum + Integer.parseInt(bits[i]);
        }
        if (needToMultiply) {
            int sum2 = 1;
            for (int i = 0; i < bits.length; i++) {
                sum2 = sum2 * Integer.parseInt(bits[i]);

            }
            return sum2;

        }

        return sum;
    }
}


