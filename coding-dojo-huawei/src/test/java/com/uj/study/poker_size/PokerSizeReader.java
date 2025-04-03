package com.uj.study.poker_size;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;
import java.util.Arrays;

/**
 * 扑克牌大小比较的输入读取器
 * 支持的牌型：个子、对子、三个、炸弹、顺子、对王
 */
public class PokerSizeReader extends ValidLineReader {

    // 常量定义
    private static final String VALID_CARDS = "3456789JQKA2";
    private static final String JOKER = "JOKER";
    private static final String SMALL_JOKER = "joker";

    /**
     * 构造函数
     * @param lineReader 行读取器
     */
    public PokerSizeReader(LineReader lineReader) {
        super(lineReader);
        this.lineReader = lineReader;
    }

    /**
     * 验证输入字符串是否有效
     * @param input 输入字符串
     * @return 是否有效
     */
    @Override
    protected boolean isValidString(String input) {
        // 验证输入格式
        if (!isValidFormat(input)) {
            return false;
        }

        // 分割输入为两手牌
        String[] parts = input.split("-");
        String[] firstHand = parts[0].trim().split("\\s+");
        String[] secondHand = parts[1].trim().split("\\s+");
        
        // 验证每张牌是否合法
        if (!areAllCardsValid(firstHand) || !areAllCardsValid(secondHand)) {
            return false;
        }
        
        // 验证每手牌是否是有效的牌型
        if (!isValidCardType(firstHand) || !isValidCardType(secondHand)) {
            return false;
        }
        
        // 验证两手牌是否可以比较
        return canCompare(firstHand, secondHand);
    }

    /**
     * 验证输入格式是否正确
     * @param input 输入字符串
     * @return 是否格式正确
     */
    private boolean isValidFormat(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // 检查是否只包含一个"-"
        if (!input.contains("-") || input.indexOf("-") != input.lastIndexOf("-")) {
            return false;
        }

        // 检查"-"两边是否有空格
        if (input.contains(" -") || input.contains("- ")) {
            return false;
        }

        // 检查"-"两边是否都有内容
        String[] parts = input.split("-");
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * 验证所有牌是否合法
     * @param cards 牌数组
     * @return 是否所有牌都合法
     */
    private boolean areAllCardsValid(String[] cards) {
        for (String card : cards) {
            if (!isValidCard(card)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证单张牌是否合法
     * @param card 牌
     * @return 是否合法
     */
    private boolean isValidCard(String card) {
        // 严格匹配 joker 和 JOKER
        if (JOKER.equals(card) || SMALL_JOKER.equals(card)) {
            return true;
        }

        // 处理数字10
        if ("10".equals(card)) {
            return true;
        }

        // 处理其他单个字符的牌，注意大小写敏感
        return card.length() == 1 && VALID_CARDS.contains(card);
    }

    /**
     * 验证牌型是否有效
     * @param cards 牌数组
     * @return 是否是有效牌型
     */
    private boolean isValidCardType(String[] cards) {
        int length = cards.length;
        
        // 个子：单张牌
        if (length == 1) {
            return true;
        }
        
        // 对王：joker和JOKER，必须是这个顺序
        if (length == 2 && cards[0].equals(SMALL_JOKER) && cards[1].equals(JOKER)) {
            return true;
        }
        
        // 对子：两张相同的牌，但不能是两个JOKER或两个joker
        if (length == 2) {
            if ((cards[0].equals(JOKER) && cards[1].equals(JOKER)) ||
                (cards[0].equals(SMALL_JOKER) && cards[1].equals(SMALL_JOKER))) {
                return false;
            }
            return cards[0].equals(cards[1]);
        }
        
        // 三个：三张相同的牌
        if (length == 3) {
            return cards[0].equals(cards[1]) && cards[1].equals(cards[2]);
        }
        
        // 炸弹：四张相同的牌
        if (length == 4) {
            return cards[0].equals(cards[1]) && cards[1].equals(cards[2]) && cards[2].equals(cards[3]);
        }
        
        // 顺子：连续5张
        if (length == 5) {
            // 这里应该实现顺子的验证逻辑
            // 暂时简化处理，假设所有5张牌都是有效的顺子
            return true;
        }
        
        return false;
    }

    /**
     * 判断是否是对王
     * @param cards 牌数组
     * @return 是否是对王
     */
    private boolean isJokerPair(String[] cards) {
        return cards.length == 2 && 
               cards[0].equals(SMALL_JOKER) && cards[1].equals(JOKER);
    }

    /**
     * 判断是否是炸弹
     * @param cards 牌数组
     * @return 是否是炸弹
     */
    private boolean isBomb(String[] cards) {
        return cards.length == 4 && 
               cards[0].equals(cards[1]) && 
               cards[1].equals(cards[2]) && 
               cards[2].equals(cards[3]);
    }

    /**
     * 判断两手牌是否可以比较
     * @param firstHand 第一手牌
     * @param secondHand 第二手牌
     * @return 是否可以比较
     */
    private boolean canCompare(String[] firstHand, String[] secondHand) {
        // 对王可以和任何牌型比较
        if (isJokerPair(firstHand) || isJokerPair(secondHand)) {
            return true;
        }
        
        // 炸弹可以和任何牌型比较
        if (isBomb(firstHand) || isBomb(secondHand)) {
            return true;
        }
        
        // 其他情况下，两手牌必须是相同类型
        return firstHand.length == secondHand.length;
    }

    /**
     * 读取有效的牌输入
     * @return 有效的牌输入
     */
    public String readCard() {
        return readValidLine("please input card: like 2-3 or A-K ");
    }
}
