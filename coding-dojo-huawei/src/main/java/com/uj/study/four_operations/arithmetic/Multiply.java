package com.uj.study.four_operations.arithmetic;

import com.uj.study.four_operations.Operand;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/18 下午12:56
 * @description：
 */
public class Multiply extends Arithmetic {

    public Multiply(int opIdx, Operand op1, Operand op2) {
        super(opIdx, op1, op2);

    }

    @Override
    public int calculate() {
        return op1.getData() * op2.getData();
    }
}
