package com.uj.study.combine.table.record;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pair {
    private Integer key;
    private Integer value;

    @Override
    public String toString() {
        return key + " " + value;
    }
}
