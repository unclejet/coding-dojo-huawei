package com.uj.study.dna;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.uj.study.dna.DnaSequenceCounter.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/12/21 下午12:45
 * @description： 描述
 * <p>
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 * <p>
 * 数据范围：字符串长度满足 1≤n≤1000 1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * <p>
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述：
 * <p>
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 * 示例1
 * 输入：
 * <p>
 * ACGT
 * 2
 * <p>
 * 输出：
 * <p>
 * CG
 * <p>
 * 说明：
 * <p>
 * ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG
 * <p>
 * 示例2
 * 输入：
 * <p>
 * AACTGTGCACGACCTGA
 * 5
 * <p>
 * 输出：
 * <p>
 * GCACG
 * <p>
 * 说明：
 * <p>
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 */
public class DnaSequenceTest {
    public static final String ACG = "ACG";

    @Test
    void length1() {
        assertThat(gcRatio(ACG, 1), is("C"));
    }

    @Test
    void splitString() {
        assertThat(splitStrByLength(ACG, 1), contains("A", C, G));
        assertThat(splitStrByLength(ACG, 2), contains("AC", "CG"));
        assertThat(splitStrByLength(ACG, 3), contains(ACG));
        assertThat(splitStrByLength("AACTGTGCACGACCTGA", 5), contains("AACTG", "ACTGT", "CTGTG", "TGTGC",
                "GTGCA", "TGCAC", "GCACG", "CACGA", "ACGAC", "CGACC", "GACCT", "ACCTG", "CCTGA"));
    }

    @Test
    void calculate_CG_number_correctly() {
        assertThat(numberOfCG("TGTGC"), is(3));
        assertThat(numberOfCG("GCACG"), is(4));
    }

    @Test
    void calculateRatio() {
        assertThat(gcRatio("ACGT", 2), is("CG"));
        assertThat(gcRatio("AACTGTGCACGACCTGA", 5), is("GCACG"));
    }
}
