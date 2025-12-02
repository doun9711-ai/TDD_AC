package org.example;

public class Calc {

    public static int run(String exp) {

        exp = exp.replace("- ", "+ -");

        boolean needToPlus = exp.contains("+");
        boolean needToMultiply = exp.contains("*");

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        }
        else if  (needToMultiply) {
            bits = exp.split(" \\* ");
        }



        int sum = 0;
        for ( int i = 0; i < bits.length; i++) {
            sum = sum + Integer.parseInt(bits[i]);
        }
        if (needToMultiply){
            int a = Integer.parseInt(bits[0]);
            int b = Integer.parseInt(bits[1]);
            int c = Integer.parseInt(bits[2]);
            return a*b*c;
        }

        return sum;
    }
}


