package com.uj.study.four_operations;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/10 下午12:49
 * @description：
 */
@Data
@AllArgsConstructor
public class Operand {
    private int index;
    private int length;
    private int data;
}
