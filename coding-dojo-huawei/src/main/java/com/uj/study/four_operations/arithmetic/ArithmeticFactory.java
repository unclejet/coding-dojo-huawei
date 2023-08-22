package com.uj.study.four_operations.arithmetic;

import com.uj.study.four_operations.Operand;

import static com.uj.study.four_operations.arithmetic.Arithmetic.*;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/18 下午12:53
 * @description：
 */
public class ArithmeticFactory {


    private ArithmeticFactory() {}

    public static Arithmetic getArithmetic(String op) {

        int mulIdx = op.indexOf(MUL);
        if (mulIdx > 0) {
            return new Multiply(mulIdx, findNumberLeft(op, mulIdx), findNumberRight(op, mulIdx));
        }
        int divIdx = op.indexOf(DIV);
        if (divIdx > 0) {
            return new Divide(divIdx, findNumberLeft(op, divIdx), findNumberRight(op, divIdx));
        }
        int addIdx = op.indexOf(ADD);
        if (addIdx > 0) {
            return new Add(addIdx, findNumberLeft(op, addIdx), findNumberRight(op, addIdx));
        }
        int subIdx = op.indexOf(SUB);
        if (subIdx > 0) {
            return new Subtract(subIdx, findNumberLeft(op, subIdx), findNumberRight(op, subIdx));
        }
        return null;
    }

    private static Operand findNumberLeft(String op, int fromIdx) {
        int count = 0;
        int idx = fromIdx - 1;
        while (idx >= 0 && Character.isDigit(op.charAt(idx))) {
            idx--;
            count++;
        }
        int data = Integer.parseInt(op.substring(fromIdx - count, fromIdx));
        if (op.charAt(0) == '-') {
            data = -data;
            count++;
        }
        return new Operand(fromIdx - count, count, data);
    }

    private static Operand findNumberRight(String op, int fromIdx) {
        int count = 0;
        int idx = fromIdx + 1;
        while (idx < op.length() && Character.isDigit(op.charAt(idx))) {
            idx++;
            count++;
        }
        return new Operand(fromIdx + 1, count,
                Integer.parseInt(op.substring(fromIdx + 1, fromIdx + count + 1)));
    }
}
