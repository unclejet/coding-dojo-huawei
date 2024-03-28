package com.uj.study.matrix_multiply_computation;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/21 下午12:46
 * @description：
 */
public class InvalidMatrixRuleException extends RuntimeException {
    private Matrix m1;
    private Matrix m2;

    public InvalidMatrixRuleException(Matrix m1, Matrix m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    @Override
    public String toString() {
        return m1.toString() + " multiply " + m2.toString() + "is invalid, make sure x,y and y,z";
    }
}
