package com.uj.study.compute_string_edit_distance;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/1 下午12:48
 * @description：
 */
class Operation {
    private int count;
    private String data;

    public Operation(int count, String data) {
        this.count = count;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public String getData() {
        return data;
    }
}
