package com.uj.study.yanghui_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/25 下午12:51
 * @description：
 */
public class YangHuiTriangle {

    public static int getFirstEvenNumber(List<TriangleRowData> triangleRowDataList, int row) {
        TriangleRowData trd = triangleRowDataList.get(row - 1);
        return findFirstEvenNumber(trd);
    }

    private static int findFirstEvenNumber(TriangleRowData trd) {
        List<Integer> data = trd.getData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) % 2 == 0)
                return i + 1;
        }
        return -1;
    }

    public static List<TriangleRowData> generateTriangle(int row) {
        List<TriangleRowData> result = new ArrayList<>(row);
        result.add(line1());
        for (int i = 1; i < row; i++) {
            TriangleRowData up = result.get(i - 1);
            List<Integer> extend = extend(up);
            result.add(generateCurrentRowData(extend, i + 1, (i + 1 << 1) - 1));
        }

        return result;
    }

    private static TriangleRowData generateCurrentRowData(List<Integer> extend, int curRow, int size) {
        TriangleRowData trd = new TriangleRowData(curRow);
        for (int j = 0, start = 0; j < size; j++, start++) {
            int data = extend.get(start) + extend.get(start + 1) + extend.get(start + 2);
            trd.add(data);
        }
        return trd;
    }

    private static List<Integer> extend(TriangleRowData up) {
        List<Integer> extend = new ArrayList<>();
        extend.add(0);
        extend.add(0);
        extend.addAll(up.getData());
        extend.add(0);
        extend.add(0);
        return extend;
    }

    private static TriangleRowData line1() {
        TriangleRowData triangleRowData = new TriangleRowData(1);
        triangleRowData.add(1);
        return triangleRowData;
    }
}
