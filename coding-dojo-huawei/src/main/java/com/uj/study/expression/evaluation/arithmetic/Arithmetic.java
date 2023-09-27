package com.uj.study.expression.evaluation.arithmetic;

import com.uj.study.expression.evaluation.Operand;
import lombok.Data;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/18 下午12:32
 * @description：
 */
@Data
public abstract class Arithmetic {
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";

    protected int optIdx;
    protected Operand op1;
    protected Operand op2;

    public Arithmetic(int optIdx, Operand op1, Operand op2) {
        this.optIdx = optIdx;
        this.op1 = op1;
        this.op2 = op2;
    }

    public abstract int calculate();
}
