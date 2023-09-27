package com.uj.study.expression.evaluation.arithmetic;

import com.uj.study.expression.evaluation.Operand;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/21 下午12:42
 * @description：
 */
public class Subtract extends Arithmetic {
    public Subtract(int optIdx, Operand a, Operand b) {
        super(optIdx, a, b);
    }

    @Override
    public int calculate() {
        return op1.getData() - op2.getData();
    }
}
