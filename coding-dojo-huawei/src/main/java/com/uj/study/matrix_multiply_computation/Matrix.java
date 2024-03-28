package com.uj.study.matrix_multiply_computation;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/21 下午12:45
 * @description：
 */
public class Matrix {
    int row;
    int column;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
