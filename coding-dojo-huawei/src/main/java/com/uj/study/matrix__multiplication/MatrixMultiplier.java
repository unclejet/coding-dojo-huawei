package com.uj.study.matrix__multiplication;

public class MatrixMultiplier {
    private int row;
    private int column;
    private int y;
    private int[] arrA;
    private int[] arrB;

    public MatrixMultiplier() {
    }

    int[] multiply() {
        int length = row * column;
        int[] matrix = new int[length];

        for (int idx = 0; idx < length; idx++) {
            int sum = 0;
            int ia = (idx / column) * y;
            int ib = idx % column;
            for (int k = 0; k < y; k++) {
                sum += arrA[ia++] * arrB[ib + k * column];
            }
            matrix[idx] = sum;
        }
        return matrix;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setArrA(int[] arrA) {
        this.arrA = arrA;
    }

    public void setArrB(int[] arrB) {
        this.arrB = arrB;
    }
}