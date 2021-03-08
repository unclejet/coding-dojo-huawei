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
    void secondLineUseBlankSeparate3Integers() {
        lineReaderStub.simulateUserInputs("1000 1", "800 2 0");
        inputReader.readTotalNum();
        List<Goods> goodsList = inputReader.readGoods();
        assertThat(goodsList.get(0).getPrice(), is(800));
        assertThat(goodsList.get(0).getWeight(), is(2));
        assertThat(goodsList.get(0).getType(), is(0));
    }
}
