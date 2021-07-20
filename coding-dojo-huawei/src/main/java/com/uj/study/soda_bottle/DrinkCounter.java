package com.uj.study.soda_bottle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/7/19 下午4:19
 * @description：
 */
public class DrinkCounter {

    public static final int BORROW_ONE_BOTTLE = 1;

    public static List<Integer> count(List<Integer> bottles) {
        List<Integer> result = new ArrayList<>();
        for (Integer bottle : bottles) {
            result.add(drinkCount(bottle));
        }
        return result;
    }

    private static Integer drinkCount(Integer bottle) {
        if (bottle < 3) {
            return 0;
        }
        int shang = bottle / 3;
        int yushu = bottle % 3;
        if (isNotEnoughBottle(shang, yushu))
            return shang;
        int leftBottles = shang + yushu;
        return leftBottles == 2 ? shang + BORROW_ONE_BOTTLE : shang + drinkCount(leftBottles);
    }

    private static boolean isNotEnoughBottle(int shang, int yushu) {
        return yushu == 0 && shang < 3;
    }
}
