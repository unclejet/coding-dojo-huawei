package com.uj.study.yanghui_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/4 下午12:38
 * @description：
 */
public class TriangleRowData {
    private List<Integer> data = null;
    private int rowNumber;

    public TriangleRowData(int row) {
        data = new ArrayList<>( (row << 1) - 1);
        this.rowNumber = row;
    }

    public List<Integer> getData() {
        return data;
    }

    public void add(Integer number) {
        data.add(number);
    }

}
