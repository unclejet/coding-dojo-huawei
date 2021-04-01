package com.uj.study.shopping_list;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/2/24 下午6:08
 * @description：
 */
public class ShoppingListUserInputReaderTest extends BaseUserInputReaderTest {
    private ShoppingListUserInputReader inputReader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        inputReader = new ShoppingListUserInputReader(lineReaderStub);
    }

    @Test
    void firstLineUseBlankSeparate2Integers_firstLessThan32000_secondLessThan60() {
        lineReaderStub.simulateUserInputs("abc 1", "32000 5", "31000 60", "1000&1", "31999 59");
        inputReader.readTotalNum();
        assertThat(inputReader.getTotalMoney(), is(31999));
        assertThat(inputReader.getTotalGoodsNum(), is(59));
    }

    @Test
    void secondLineUseBlankSeparate3PositiveIntegers() {
        lineReaderStub.simulateUserInputs("1000 1", "a b c", "-800 2 0", "800&2 0", "800 2 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(800));
        assertThat(goodsList.get(0).getWeight(), is(2));
        assertThat(goodsList.get(0).getType(), is(0));
    }

    @Test
    void secondLineRule_firstColumnLessThan_10000() {
        lineReaderStub.simulateUserInputs("1000 1", "10001 2 0", "10000 2 0", "9999 2 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(9999));
        assertThat(goodsList.get(0).getWeight(), is(2));
        assertThat(goodsList.get(0).getType(), is(0));
    }

    @Test
    void secondLineRule_secondColumnBetween_1and5() {
        lineReaderStub.simulateUserInputs("1000 1", "800 0 0", "800 6 0", "800 5 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(800));
        assertThat(goodsList.get(0).getWeight(), is(5));
        assertThat(goodsList.get(0).getType(), is(0));
    }

    @Test
    void secondLineRule_thirdColumn_greaterEqualThan_0() {
        lineReaderStub.simulateUserInputs("1000 1", "800 0 -1", "800 5 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(800));
        assertThat(goodsList.get(0).getWeight(), is(5));
        assertThat(goodsList.get(0).getType(), is(0));
    }

    @Test
    void majorAndAttachmentGoodsRelationIsCorrect() {
        lineReaderStub.simulateUserInputs("1000 5", "800 2 0", "400 5 1", "300 5 1", "400 3 0", "500 2 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(800));
        assertThat(goodsList.get(0).getAttachmentList().get(0).getPrice(), is(400));
        assertThat(goodsList.get(0).getAttachmentList().get(1).getPrice(), is(300));
        assertThat(goodsList.get(1).getPrice(), is(400));
        assertThat(goodsList.get(2).getPrice(), is(500));
    }
}
