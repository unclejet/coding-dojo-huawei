package com.uj.study.poker_size;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 描述
 *
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 *
 * （4）输入的两手牌不会出现相等的情况。
 *
 * 数据范围：字符串长度：3≤s≤10 3≤s≤10
 *
 *
 *
 * 输入描述：
 *
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如 4 4 4 4-joker JOKER。
 * 输出描述：
 *
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 * 示例1
 * 输入：
 *
 * 4 4 4 4-joker JOKER
 *
 * 输出：
 *
 * joker JOKER
 */
public class PokerSizeTest {
    @Test
    void single_card_comparison() {
        // 测试数字牌之间的比较
        String poker = "4-3";
        String result = comparePokerSize(poker);
        Assertions.assertEquals("4", result);
        
        // 测试数字牌和字母牌的比较
        poker = "10-J";
        result = comparePokerSize(poker);
        Assertions.assertEquals("J", result);
        
        // 测试字母牌之间的比较
        poker = "J-Q";
        result = comparePokerSize(poker);
        Assertions.assertEquals("Q", result);
        
        // 测试字母牌和2的比较
        poker = "A-2";
        result = comparePokerSize(poker);
        Assertions.assertEquals("2", result);
        
        // 测试2和小王的比较
        poker = "2-joker";
        result = comparePokerSize(poker);
        Assertions.assertEquals("joker", result);
        
        // 测试小王和大王的比较
        poker = "joker-JOKER";
        result = comparePokerSize(poker);
        Assertions.assertEquals("JOKER", result);
        
        // 测试跨度较大的比较
        poker = "3-JOKER";
        result = comparePokerSize(poker);
        Assertions.assertEquals("JOKER", result);
    }

    @Test
    void pair_comparison() {
        // 测试数字对子之间的比较
        String poker = "4 4-3 3";
        String result = comparePokerSize(poker);
        Assertions.assertEquals("4 4", result);
        
        // 测试字母对子的比较
        poker = "J J-Q Q";
        result = comparePokerSize(poker);
        Assertions.assertEquals("Q Q", result);
        
        // 测试数字对子和字母对子的比较
        poker = "10 10-K K";
        result = comparePokerSize(poker);
        Assertions.assertEquals("K K", result);
        
        // 测试对子和对王的比较（对王是最大的）
        poker = "2 2-joker JOKER";
        result = comparePokerSize(poker);
        Assertions.assertEquals("joker JOKER", result);
        
        // 测试不同类型牌的比较（应该返回ERROR，因为单牌不能和对子比较）
        poker = "K-3 3";
        result = comparePokerSize(poker);
        Assertions.assertEquals("ERROR", result);
    }

    @Test
    void three_of_a_kind_comparison() {
        // 测试数字三个的比较
        String poker = "4 4 4-3 3 3";
        String result = comparePokerSize(poker);
        Assertions.assertEquals("4 4 4", result);
        
        // 测试字母三个的比较
        poker = "J J J-Q Q Q";
        result = comparePokerSize(poker);
        Assertions.assertEquals("Q Q Q", result);
        
        // 测试与炸弹的比较（炸弹更大）
        poker = "K K K-4 4 4 4";
        result = comparePokerSize(poker);
        Assertions.assertEquals("4 4 4 4", result);
        
        // 测试与对子的比较（不同类型，返回ERROR）
        poker = "A A A-3 3";
        result = comparePokerSize(poker);
        Assertions.assertEquals("ERROR", result);
    }

    @Test
    void bomb_comparison() {
        // 测试数字炸弹之间的比较
        String poker = "4 4 4 4-3 3 3 3";
        String result = comparePokerSize(poker);
        Assertions.assertEquals("4 4 4 4", result);
        
        // 测试字母炸弹的比较
        poker = "J J J J-Q Q Q Q";
        result = comparePokerSize(poker);
        Assertions.assertEquals("Q Q Q Q", result);
        
        // 测试与单牌的比较（炸弹更大）
        poker = "K K K K-A";
        result = comparePokerSize(poker);
        Assertions.assertEquals("K K K K", result);
        
        // 测试与对子的比较（炸弹更大）
        poker = "A A A A-3 3";
        result = comparePokerSize(poker);
        Assertions.assertEquals("A A A A", result);
        
        // 测试与三个的比较（炸弹更大）
        poker = "2 2 2 2-A A A";
        result = comparePokerSize(poker);
        Assertions.assertEquals("2 2 2 2", result);
        
        // 测试与对王的比较（对王更大）
        poker = "A A A A-joker JOKER";
        result = comparePokerSize(poker);
        Assertions.assertEquals("joker JOKER", result);
    }

    @Test
    void straight_comparison() {
        // 测试顺子之间的比较（比较最小牌）
        String poker = "3 4 5 6 7-4 5 6 7 8";
        String result = comparePokerSize(poker);
        Assertions.assertEquals("4 5 6 7 8", result);
        
        // 测试高顺子和低顺子
        poker = "8 9 10 J Q-3 4 5 6 7";
        result = comparePokerSize(poker);
        Assertions.assertEquals("8 9 10 J Q", result);
        
        // 测试顺子和炸弹的比较（炸弹更大）
        poker = "9 10 J Q K-4 4 4 4";
        result = comparePokerSize(poker);
        Assertions.assertEquals("4 4 4 4", result);
        
        // 测试顺子和单牌的比较（不同类型，返回ERROR）
        poker = "6 7 8 9 10-A";
        result = comparePokerSize(poker);
        Assertions.assertEquals("ERROR", result);
        
        // 测试顺子和对子的比较（不同类型，返回ERROR）
        poker = "5 6 7 8 9-K K";
        result = comparePokerSize(poker);
        Assertions.assertEquals("ERROR", result);
        
        // 测试顺子和三个的比较（不同类型，返回ERROR）
        poker = "10 J Q K A-3 3 3";
        result = comparePokerSize(poker);
        Assertions.assertEquals("ERROR", result);
        
        // 测试顺子和对王的比较（对王更大）
        poker = "9 10 J Q K-joker JOKER";
        result = comparePokerSize(poker);
        Assertions.assertEquals("joker JOKER", result);
    }

    private String comparePokerSize(String poker) {
        String[] hands = poker.split("-");
        Hand hand1 = new Hand(hands[0]);
        Hand hand2 = new Hand(hands[1]);
        
        // 如果有对王，直接返回对王
        if (hand1.isJokerPair() || hand2.isJokerPair()) {
            return hand1.isJokerPair() ? hand1.getOriginal() : hand2.getOriginal();
        }
        
        // 如果类型不同且都不是炸弹，返回ERROR
        if (!canCompare(hand1, hand2)) {
            return "ERROR";
        }
        
        // 比较牌的大小
        return compareHands(hand1, hand2);
    }
    
    private enum PokerType {
        SINGLE,     // 单牌
        PAIR,       // 对子
        THREE,      // 三个
        STRAIGHT,   // 顺子
        BOMB,       // 炸弹
        JOKER_PAIR  // 对王
    }

    private static int getCardValue(String card) {
        // 定义牌的大小顺序
        switch (card) {
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            case "2": return 15;
            case "joker": return 16;
            case "JOKER": return 17;
            default: return Integer.parseInt(card);  // 处理数字牌
        }
    }

    private static class Hand {
        private final String original;
        private final String[] cards;
        private final PokerType type;
        
        Hand(String hand) {
            this.original = hand;
            this.cards = hand.split(" ");
            this.type = determineType();
        }
        
        private PokerType determineType() {
            if (isJokerPair()) {
                return PokerType.JOKER_PAIR;
            }
            
            if (cards.length == 1) {
                return PokerType.SINGLE;
            }
            
            if (cards.length == 2 && cards[0].equals(cards[1])) {
                return PokerType.PAIR;
            }
            
            if (cards.length == 3 && cards[0].equals(cards[1]) 
                && cards[1].equals(cards[2])) {
                return PokerType.THREE;
            }
            
            if (cards.length == 4 && cards[0].equals(cards[1]) 
                && cards[1].equals(cards[2]) 
                && cards[2].equals(cards[3])) {
                return PokerType.BOMB;
            }
            
            // 检查是否是顺子（5张连续的牌）
            if (cards.length == 5 && isStraight()) {
                return PokerType.STRAIGHT;
            }
            
            return null;  // 未知类型
        }
        
        // 判断是否是顺子
        private boolean isStraight() {
            // 获取所有牌的值
            int[] values = new int[5];
            for (int i = 0; i < 5; i++) {
                values[i] = getCardValue(cards[i]);
            }
            
            // 对值排序（其实顺子已排好，但为了安全）
            java.util.Arrays.sort(values);
            
            // 检查是否连续
            for (int i = 1; i < 5; i++) {
                if (values[i] != values[i-1] + 1) {
                    return false;
                }
            }
            
            return true;
        }
        
        boolean isJokerPair() {
            return original.equals("joker JOKER");
        }
        
        String getOriginal() {
            return original;
        }
        
        PokerType getType() {
            return type;
        }
        
        int getValue() {
            return getCardValue(cards[0]);  // 取第一张牌的值
        }
    }
    
    private boolean canCompare(Hand hand1, Hand hand2) {
        // 相同类型可以比较
        if (hand1.getType() == hand2.getType()) {
            return true;
        }
        // 炸弹可以和任何牌比较
        return hand1.getType() == PokerType.BOMB || hand2.getType() == PokerType.BOMB;
    }
    
    private String compareHands(Hand hand1, Hand hand2) {
        // 如果有炸弹，炸弹大
        if (hand1.getType() == PokerType.BOMB && hand2.getType() != PokerType.BOMB) {
            return hand1.getOriginal();
        }
        if (hand2.getType() == PokerType.BOMB && hand1.getType() != PokerType.BOMB) {
            return hand2.getOriginal();
        }
        
        // 比较牌值
        return hand1.getValue() > hand2.getValue() ? 
               hand1.getOriginal() : hand2.getOriginal();
    }
}
