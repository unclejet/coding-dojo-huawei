package com.uj.study.mp3_cursor_location;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/5 下午12:55
 * @description： 描述
 * <p>
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * <p>
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 * <p>
 * 1. 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * <p>
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * <p>
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 * <p>
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 * <p>
 * <p>
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 * <p>
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 * <p>
 * 其他情况，不用翻页，只是挪动光标就行。
 * 数据范围：命令长度1≤s≤100 1≤s≤100 ，歌曲数量1≤n≤150 1≤n≤150
 * 进阶：时间复杂度：O(n) O(n) ，空间复杂度：O(n) O(n)
 * 输入描述：
 * <p>
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 * 输出描述：
 * <p>
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 * 示例1
 * 输入：
 * <p>
 * 10
 * UUUU
 * <p>
 * 输出：
 * <p>
 * 7 8 9 10
 * 7
 */
public class MP3CursorLocationTest {
    private final MP3CursorLocator mp3CursorLocator = new MP3CursorLocator();

    @Test
    void one_song() {
        mp3CursorLocator.loadSong(1);
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 0, 0, 0});
    }

    @Test
    void two_songs() {
        mp3CursorLocator.loadSong(2);
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 0, 0});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(2));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 0, 0});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(1));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(2));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(1));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(2));
    }

    @Test
    void four_songs() {
        mp3CursorLocator.loadSong(4);
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(4));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(1));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(2));

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(3));
        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(2));

        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});
    }

    @Test
    void five_songs() {
        mp3CursorLocator.loadSong(5);
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.down(3);
        assertThat(mp3CursorLocator.getCursor(), is(4));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(5));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{2, 3, 4, 5});

        mp3CursorLocator.up(3);
        assertThat(mp3CursorLocator.getCursor(), is(2));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{2, 3, 4, 5});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(5));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{2, 3, 4, 5});

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});
    }

    @Test
    void ten_songs() {
        mp3CursorLocator.loadSong(10);
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(10));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{7, 8, 9, 10});

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(1));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{1, 2, 3, 4});

        mp3CursorLocator.down(6);
        assertThat(mp3CursorLocator.getCursor(), is(7));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{4, 5, 6, 7});

        mp3CursorLocator.down();
        assertThat(mp3CursorLocator.getCursor(), is(8));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{5, 6, 7, 8});

        mp3CursorLocator.up(4);
        assertThat(mp3CursorLocator.getCursor(), is(4));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{4, 5, 6, 7});

        mp3CursorLocator.up();
        assertThat(mp3CursorLocator.getCursor(), is(3));
        Assertions.assertArrayEquals(mp3CursorLocator.getScope(), new int[]{3, 4, 5, 6});
    }
}
