package com.uj.study.expression.evaluation;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/9/27 下午12:35
 * @description：
 */
public class ExpressionEvaluationUserInputTest extends BaseUserInputReaderTest {
    ExpressionEvaluationUserInputReader reader;
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new ExpressionEvaluationUserInputReader(lineReaderStub);
    }

    @Test
    void input() {
        lineReaderStub.simulateUserInputs("a+b", "^", "-1+ 2", "-1+[(2+3)*4]", "1*(2+3)");
        assertThat(reader.readOperation(), is("1*(2+3)"));
    }
}
