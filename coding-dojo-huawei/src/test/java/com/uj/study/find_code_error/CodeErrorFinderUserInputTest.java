package com.uj.study.find_code_error;

import com.uj.study.common.utils.BaseUserInputReaderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/19 上午11:38
 * @description：
 */
public class CodeErrorFinderUserInputTest extends BaseUserInputReaderTest {
    private CodeErrorFinderUserInputReader reader;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        reader = new CodeErrorFinderUserInputReader(lineReaderStub);
    }

    @Test
    void readOneLineAndRecordedCorrectly() {
        lineReaderStub.simulateUserInputs("D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr 645", "q");
        List<CodeFileErrorRecored> codeFileErrorRecoredList = reader.readCodeFileErrorRecords();
        assertThat(codeFileErrorRecoredList.size(), is(1));
        CodeFileErrorRecored recored = codeFileErrorRecoredList.get(0);
        assertThat(recored.getScore(), is("645"));
        assertThat(recored.getFilename(), is("cqzlyaszjvlsjmkwoqijggmybr"));
    }

    @Test
    void readManyLinesCorrectly() {
        lineReaderStub.simulateUserInputs(
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr645",
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr& 645",
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr",
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr abc",
                "zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr abc",
                "cqzlyaszjvlsjmkwoqijggmybr abc",
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr 645",
                "q");
        List<CodeFileErrorRecored> codeFileErrorRecoredList = reader.readCodeFileErrorRecords();
        assertThat(codeFileErrorRecoredList.size(), is(1));
    }

    @Test
    void readCorrectly() {
        lineReaderStub.simulateUserInputs(
                "D:\\zwtymj\\xccb\\ljj\\cqzlyaszjvlsjmkwoqijggmybr 645",
                "E:\\je\\rzuwnjvnuz 633",
                "C:\\km\\tgjwpb\\gy\\atl 637",
                "F:\\weioj\\hadd\\connsh\\rwyfvzsopsuiqjnr 647",
                "E:\\ns\\mfwj\\wqkoki\\eez 648",
                "D:\\cfmwafhhgeyawnool 649",
                "E:\\czt\\opwip\\osnll\\c 637",
                "G:\\nt\\f 633",
                "F:\\fop\\ywzqaop 631",
                "F:\\yay\\jc\\ywzqaop 631",
                "q");
        List<CodeFileErrorRecored> codeFileErrorRecoredList = reader.readCodeFileErrorRecords();
        assertThat(codeFileErrorRecoredList.size(), is(10));
    }
}
