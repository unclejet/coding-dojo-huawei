package com.uj.study.poker_size;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.一副牌由54张组成，含3~A、2各4张，小王1张，大王1张,牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER。
 * 2. 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 3.输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * 4. 输入的两手牌不会出现相等的情况
 * 5. 字符串长度：3≤s≤10 3≤s≤10
 */
public class PokerSizeReaderTest extends BaseUserInputReaderTest {
    PokerSizeReader reader;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        reader = new PokerSizeReader(lineReaderStub);
    }


    @Test
    public void testFormat() {
        lineReaderStub.simulateUserInputs("4#4","4-","4 -4", "4- 4", "4-  4","4 - 4", "4-joker");
        assertEquals("4-joker", reader.readCard());
    }

    @Test
    void number_is_specified() {
        lineReaderStub.simulateUserInputs("1-2", "3-L", "10-joKer", "4-JOKER");
        assertEquals("4-JOKER", reader.readCard());
    }

    @Test
    void testSingleCard() {
        // 测试无效的个子牌型，然后是有效输入
        lineReaderStub.simulateUserInputs("B-C", "1-2", "joKer-JOKER", "3-4");
        assertEquals("3-4", reader.readCard());
    }

    @Test
    void testPair() {
        // 测试无效的对子牌型，然后是有效输入
        lineReaderStub.simulateUserInputs(
                "3 4-5 5",       // 不是对子
                "J j-Q Q",       // 大小写不匹配
                "3 3 3-4 4",     // 不是对子
                "K K-A A"        // 有效输入
        );
        assertEquals("K K-A A", reader.readCard());
    }

    @Test
    void testTriple() {
        // 测试无效的三个牌型，然后是有效输入
        lineReaderStub.simulateUserInputs(
                "3 3-5 5 5",          // 不是三个
                "J J K-Q Q Q",        // 不是三个
                "3 3 3-4 4",          // 牌型不匹配
                "K K K-A A A"         // 有效输入
        );
        assertEquals("K K K-A A A", reader.readCard());
    }

    @Test
    void testStraight() {
//        // 测试有效的顺子牌型
//        lineReaderStub.simulateUserInputs(
//                "3 4 5 6 7-4 5 6 7 8",       // 3开头顺子 vs 4开头顺子
//                "5 6 7 8 9-6 7 8 9 10",      // 5开头顺子 vs 6开头顺子
//                "7 8 9 10 J-8 9 10 J Q",     // 7开头顺子 vs 8开头顺子
//                "9 10 J Q K-10 J Q K A"      // 9开头顺子 vs 10开头顺子
//        );
//        assertEquals("9 10 J Q K-10 J Q K A", reader.readCard());

        // 测试无效的顺子牌型，然后是有效输入
        lineReaderStub.simulateUserInputs(
                "3 4 5 6 8",                 // 不连续
                "3 4 5 6-7 8 9 10 J",        // 长度不匹配
                "2 3 4 5 6",                 // 2不能作为顺子的一部分
                "10 J Q K A-3 4 5 6 7"       // 有效输入
        );
        assertEquals("10 J Q K A-3 4 5 6 7", reader.readCard());
    }

    @Test
    void testBomb() {
//        // 测试有效的炸弹牌型
//        lineReaderStub.simulateUserInputs(
//                "3 3 3 3-4 4 4 4",       // 炸弹3 vs 炸弹4
//                "5 5 5 5-6 6 6 6",       // 炸弹5 vs 炸弹6
//                "7 7 7 7-8 8 8 8",       // 炸弹7 vs 炸弹8
//                "9 9 9 9-10 10 10 10",   // 炸弹9 vs 炸弹10
//                "J J J J-Q Q Q Q",       // 炸弹J vs 炸弹Q
//                "K K K K-A A A A",       // 炸弹K vs 炸弹A
//                "A A A A-2 2 2 2"        // 炸弹A vs 炸弹2
//        );
//        assertEquals("A A A A-2 2 2 2", reader.readCard());

        // 测试无效的炸弹牌型，然后是有效输入
        lineReaderStub.simulateUserInputs(
                "J J J K-Q Q Q Q",        // 不是炸弹
                "K K K K-A A A A"         // 有效输入
        );
        assertEquals("K K K K-A A A A", reader.readCard());
    }

    @Test
    void testJokerPair() {
        // 测试有效的对王牌型
//        lineReaderStub.simulateUserInputs(
//                "joker JOKER-3 4",          // 对王vs个子
//                "joker JOKER-5 5",          // 对王vs对子
//                "joker JOKER-7 7 7",        // 对王vs三个
//                "joker JOKER-9 9 9 9",      // 对王vs炸弹
//                "joker JOKER-J Q K A 2"     // 对王vs顺子
//        );
//        assertEquals("joker JOKER-J Q K A 2", reader.readCard());

        // 测试无效的对王牌型，然后是有效输入
        lineReaderStub.simulateUserInputs(
                "joker joker-3 4",          // 不是对王
                "JOKER JOKER-5 5",          // 不是对王
                "joKer JOKER-7 7",          // 大小写错误
                "joker JOKER-A A"           // 有效输入
        );
        assertEquals("joker JOKER-A A", reader.readCard());
    }

    @Test
    void mixed_case() {
        lineReaderStub.simulateUserInputs("2 2-joker JOKER");
        assertEquals("2 2-joker JOKER", reader.readCard());
        lineReaderStub.simulateUserInputs("2 2 2-joker JOKER");
        assertEquals("2 2 2-joker JOKER", reader.readCard());
        lineReaderStub.simulateUserInputs("joker JOKER-3 4 5 6 7");
        assertEquals("joker JOKER-3 4 5 6 7", reader.readCard());
        lineReaderStub.simulateUserInputs("3 4 5 6 7-2 2 2 2");
        assertEquals("3 4 5 6 7-2 2 2 2", reader.readCard());
        lineReaderStub.simulateUserInputs("joker JOKER-A A A A");
        assertEquals("joker JOKER-A A A A", reader.readCard());
        lineReaderStub.simulateUserInputs("joker-JOKER");
        assertEquals("joker-JOKER", reader.readCard());
    }
}
