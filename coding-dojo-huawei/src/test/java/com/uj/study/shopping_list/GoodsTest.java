package com.uj.study.shopping_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/15 上午11:56
 * @description：
 */
class GoodsTest {
    @Test
    void isSatisfyTotalMoney() {
        int total = 1000;
        Goods goods = new Goods(800, 2, 0);
        goods.addAttachment(new Goods(400, 5, 1));
        goods.addAttachment(new Goods(300, 5, 1));
        assertThat(goods.isSatisfy(total), is(true));
    }
}