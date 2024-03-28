package com.uj.study.matrix_multiply_computation;

import com.uj.study.common.SuperMain;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/3/28 下午12:33
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        MatrixMultiplicationComputationReader reader = new MatrixMultiplicationComputationReader(lineReader);
        System.out.println(new MatrixMultiCounter(reader.readMatrix(), reader.readRule()).count());
    }
}
