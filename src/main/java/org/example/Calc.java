package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static int run(String exp) {

        exp = exp.replace("- ", "+ -");
        //괄호 제거
        exp = stripOuterBrackets(exp);
        if (exp.contains("(")){
            exp = stripOuterBrackets(exp);
        }


        //그냥 숫자만 들어올 경우 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToPlus = exp.contains(" + ");
        boolean needToMultiply = exp.contains(" * ") || exp.contains(" - ");
        boolean needToCompond = needToPlus && needToMultiply;

        String[] bits = null;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
        }
        if (needToMultiply) {
            bits = exp.split(" \\* ");
        }
        if (needToCompond) {
            bits = exp.split(" \\+ ");


            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));
            return run(newExp);


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

    private static String stripOuterBrackets(String exp) {
        if (exp.charAt(0) == '(' && exp.charAt(exp.length() - 1) == ')') {
            exp = exp.substring(1, exp.length() - 1);
        }

        return exp;
    }
}


