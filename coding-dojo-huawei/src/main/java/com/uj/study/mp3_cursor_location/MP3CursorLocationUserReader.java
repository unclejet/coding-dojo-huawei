package com.uj.study.mp3_cursor_location;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.Arrays;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/16 下午12:47
 * @description：
 */
public class MP3CursorLocationUserReader {
    public static final String UP = "U";
    public static final String DOWN = "D";


    private SongNumberReader songNumberReader;
    private InstructorReader instructorReader;

    public MP3CursorLocationUserReader(LineReader lineReader) {
        songNumberReader = new SongNumberReader(lineReader);
        instructorReader = new InstructorReader(lineReader);
    }

    public int readSongNumber() {
        return songNumberReader.readNumber();
    }

    public String readInstructions() {
        return instructorReader.readInstruction();
    }

    class SongNumberReader extends ValidLineReader {

        public SongNumberReader(LineReader lineReader) {
            super(lineReader);
        }

        int readNumber() {
            String line = readValidLine("please input song number >= 1 and <= 150:");
            return getInteger(line);
        }

        @Override
        protected boolean isValidString(String line) {
            if (isInteger(line)) {
                int n = getInteger(line);
                return n >= 1 && n <= 150;
            }
            return false;
        }

    }

    class InstructorReader extends ValidLineReader {
        public InstructorReader(LineReader lineReader) {
            super(lineReader);
        }

        String readInstruction() {
            return readValidLine("please input U & D instruction <= 100 times:");
        }

        @Override
        protected boolean isValidString(String line) {
            if (Arrays.stream(line.split("")).allMatch(s -> UP.equals(s) || DOWN.equals(s))) {
                return line.length() <= 100;
            }
            return false;
        }

    }
}
