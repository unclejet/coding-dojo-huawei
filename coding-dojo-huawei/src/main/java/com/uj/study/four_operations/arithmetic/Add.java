package com.uj.study.four_operations.arithmetic;

import com.uj.study.four_operations.Operand;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/21 下午12:40
 * @description：
 */
public class Add extends Arithmetic{
    public Add(int optIdx, Operand a, Operand b) {
        super(optIdx, a, b);
    }

    @Override
    public int calculate() {
        return op1.getData() + op2.getData();
    }
}
