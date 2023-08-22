package com.uj.study.four_operations;

import lombok.Data;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/7/26 下午12:52
 * @description：
 */
@Data
public abstract class Equation {
    protected int op1;
    protected int op2;
    protected int posIdx;
    protected int result;

    public Equation(int op1, int op2, int posIdx) {
        this.op1 = op1;
        this.op2 = op2;
        this.posIdx = posIdx;
    }
}
