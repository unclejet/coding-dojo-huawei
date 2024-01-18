package com.uj.study.mp3_cursor_location;

import com.uj.study.common.SuperMain;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/17 下午12:53
 * @description：
 */
public class Main extends SuperMain {
    public static void main(String[] args) {
        MP3CursorLocationUserReader reader = new MP3CursorLocationUserReader(lineReader);
        int songNumber = reader.readSongNumber();
        String instructions = reader.readInstructions();
        MP3CursorLocator locator = new MP3CursorLocator();
        locator.loadSong(songNumber);
        locator.execute(instructions);
        System.out.println(Arrays.toString(locator.getScope()));
        System.out.println(locator.getCursor());
    }
}
