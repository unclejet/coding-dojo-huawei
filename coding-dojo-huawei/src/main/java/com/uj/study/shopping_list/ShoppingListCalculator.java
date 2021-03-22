package com.uj.study.shopping_list;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/11 上午11:57
 * @description：
 */
public class ShoppingListCalculator {
    public static int calculate(int totalMoney, List<Goods> goodsList) {
        List<Goods> descPriceGoods = sortGoodsByPriceDesc(goodsList);
        int maxValue = 0;
        int accumulatePrice = 0;
        for (int i = 0; i < descPriceGoods.size(); i++) {
            Goods goods = descPriceGoods.get(i);
            if (accumulatePrice + goods.totalPrice() < totalMoney &&
                maxValue + goods.getValue() < 200000) {
                accumulatePrice += goods.totalPrice();
                maxValue += goods.getValue();
            }
        }
        return maxValue;
    }

    private static List<Goods> sortGoodsByPriceDesc(List<Goods> goodsList) {
        return goodsList.stream()
                .sorted(Comparator.comparing(Goods::getPrice).reversed())
                .collect(Collectors.toList());
    }
}
