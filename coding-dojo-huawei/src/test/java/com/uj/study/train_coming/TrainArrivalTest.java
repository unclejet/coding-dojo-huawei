package com.uj.study.train_coming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

/**
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：1≤n≤10 1≤n≤10
 * 进阶：时间复杂度：O(n!) O(n!) ，空间复杂度：O(n) O(n)
 * 输入描述：
 *
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 * 输出描述：
 *
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * 示例1
 * 输入：
 *
 * 3
 * 1 2 3
 *
 * 输出：
 *
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 *
 * 说明：
 *
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class TrainArrivalTest {
    private final TrainArrivalService service = new TrainArrivalService();

    @Test
    void one_train_arrival_test() {
        int[] trains = {1};
        assertThat(service.getTrainArrivals(trains), contains("1"));
    }

    @Test
    void two_train_arrival_test() {
        int[] trains = {1, 2};
        assertThat(service.getTrainArrivals(trains), containsInAnyOrder("1 2",  "2 1"));
    }

    @Test
    void three_train_arrival_test() {
        int[] trains = {1, 2, 3};
        assertThat(service.getTrainArrivals(trains), containsInAnyOrder("1 2 3", "1 3 2", "2 1 3", "2 3 1", "3 2 1"));
    }

    @Test
    void four_train_arrival_test() {
        int[] trains = {1, 2, 3, 4};
        assertThat(service.getTrainArrivals(trains), containsInAnyOrder(
            "1 2 3 4",
            "1 2 4 3",
            "1 3 2 4",
            "1 3 4 2",
            "1 4 3 2",
            "2 1 3 4",
            "2 1 4 3",
            "2 3 1 4",
            "2 3 4 1",
            "2 4 3 1",
            "3 2 1 4",
            "3 2 4 1",
            "3 4 2 1",
            "4 3 2 1"
        ));
    }
}
