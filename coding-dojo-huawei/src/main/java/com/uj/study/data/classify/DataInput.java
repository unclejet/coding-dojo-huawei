package com.uj.study.data.classify;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/11/25 上午11:56
 * @description：
 */
@Builder
@Data
public class DataInput {
    public static final String DELIMITER = " ";
    private int index;
    private String data;

    @Override
    public String toString() {
        return index + DELIMITER + data;
    }
}
