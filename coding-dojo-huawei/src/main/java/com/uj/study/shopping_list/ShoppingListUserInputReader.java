package com.uj.study.shopping_list;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/25 上午11:28
 * @description：
 */
public class ShoppingListUserInputReader extends UserInputReader {
    public static final Pattern FIRST_LINE_PATTERN = Pattern.compile("(\\d+)\\s+(\\d+)");
    public static final Pattern SECOND_LINE_PATTERN = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)");
    public static final int TOTAL_MONEY_NUM = 32000;
    public static final int TOTAL_GOODS_NUM = 60;

    private int totalMoney;
    private int totalGoodsNum;
    private int count;

    public ShoppingListUserInputReader(LineReader lineReader) {
        super(lineReader);
    }

    public void readTotalNum() {
        Matcher matcher = FIRST_LINE_PATTERN.matcher(lineReader.readLine());
        while (!isValidFirstLine(matcher)) {
            System.out.println("Please input N(<32000) m(<60) like this: 1000 5");
            matcher = FIRST_LINE_PATTERN.matcher(lineReader.readLine());
        }
        totalMoney = Integer.parseInt(matcher.group(1));
        totalGoodsNum = Integer.parseInt(matcher.group(2));
    }

    private boolean isValidFirstLine(Matcher matcher) {
        return matcher.find() &&
                isValidTotalMoney(Integer.parseInt(matcher.group(1))) &&
                isValidTotalGoodsNum(Integer.parseInt(matcher.group(2)));
    }

    private boolean isValidTotalMoney(int totalMoney) {
        return totalMoney < TOTAL_MONEY_NUM;
    }

    private boolean isValidTotalGoodsNum(int totalGoodsNum) {
        return totalGoodsNum < TOTAL_GOODS_NUM;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getTotalGoodsNum() {
        return totalGoodsNum;
    }

    public List<Goods> readGoods() {
        List<Goods> goods = new ArrayList<>();
        count = 0;
        Matcher matcher = SECOND_LINE_PATTERN.matcher(lineReader.readLine());
        while (needRead()) {
            while (!isValidLine(matcher)) {
                System.out.println("Please input v(v<10000) p(1~5) q(0 or !0) like this: 800 2 0");
                matcher = SECOND_LINE_PATTERN.matcher(lineReader.readLine());
            }
            goods.add(new Goods(Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3))));
        }
        return goods;
    }

    private boolean isValidLine(Matcher matcher) {
//        boolean b = matcher.find();
//        int i1 = Integer.parseInt(matcher.group(1));
//        int i2 = Integer.parseInt(matcher.group(2));
//        int i3 = Integer.parseInt(matcher.group(2));
//        boolean b1 = matcher.find() &&
//                Integer.parseInt(matcher.group(1)) < 10000;
//        boolean b2 = Integer.parseInt(matcher.group(2)) >= 1;
//        boolean b3 = Integer.parseInt(matcher.group(2)) <= 5;
        boolean b4 = matcher.find() &&
                Integer.parseInt(matcher.group(1)) < 10000 &&
                Integer.parseInt(matcher.group(2)) >= 1 &&
                Integer.parseInt(matcher.group(2)) <= 5;
        return b4;
    }

    private boolean needRead() {
        return count++ < totalGoodsNum;
    }
}
