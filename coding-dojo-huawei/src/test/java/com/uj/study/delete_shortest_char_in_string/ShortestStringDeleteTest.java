package com.uj.study.delete_shortest_char_in_string;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/9/18 下午12:16
 * @description：
 * 描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述：
 *
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述：
 *
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入：
 *
 * abcdd
 * aabcddd
 *
 * 输出：
 *
 * dd
 * aaddd
 *
 */
public class ShortestStringDeleteTest {
    @Test
    void singleCharacter() {
        assertThat(ShortestStringDelete.shortIt("a"), is("a"));
        assertThat(ShortestStringDelete.shortIt("ab"), is("ab"));
    }

    @Test
    void duplicateCharacters() {
        assertThat(ShortestStringDelete.shortIt("aabb"), is("aabb"));
        assertThat(ShortestStringDelete.shortIt("acbb"), is("bb"));
        assertThat(ShortestStringDelete.shortIt("aabcddd"), is("aaddd"));
    }
}
