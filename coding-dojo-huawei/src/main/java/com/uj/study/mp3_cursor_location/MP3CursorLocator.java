package com.uj.study.mp3_cursor_location;

public class MP3CursorLocator {
    public static final int SCREEN_SIZE = 4;

    private int cursor;
    private int[] scope = new int[SCREEN_SIZE];
    private int[] songs;

    public MP3CursorLocator() {
    }

    void up(int times) {
        for (int i = 0; i < times; i++) {
            up();
        }
    }

    void down(int times) {
        for (int i = 0; i < times; i++) {
            down();
        }
    }

    void down() {
        boolean isPage = false;
        if (++cursor > songs[songs.length - 1]) {
            isPage = true;
            cursor = songs[0];
        }
        if (songs.length > SCREEN_SIZE) {
            if (isPage) {
                reloadScopeFrom(cursor);
            } else if (cursor > scope[scope.length - 1]) {
                reloadScopeFrom(scope[0] + 1);
            }

        }
    }

    private void reloadScopeFrom(int start) {
        for (int i = 0; i < SCREEN_SIZE; i++) {
            scope[i] = start + i;
        }
    }

    void up() {
        boolean isPage = false;
        if (--cursor < songs[0]) {
            isPage = true;
            cursor = songs[songs.length - 1];
        }
        if (songs.length > SCREEN_SIZE) {
            if (isPage) {
                reloadScopeFrom(cursor - 3);
            } else if (cursor < scope[0]) {
                reloadScopeFrom(scope[0] - 1);
            }
        }
    }

    public int getCursor() {
        return cursor;
    }

    public int[] getScope() {
        return scope;
    }

    void loadSong(int number) {
        songs = new int[number];
        for (int i = 0; i < number; i++) {
            songs[i] = i + 1;
        }

        for (int i = 0; i < SCREEN_SIZE && i < number; i++) {
            scope[i] = songs[i];
        }

        cursor = scope[0];
    }

    public void execute(String instructions) {
        for (String s : instructions.split("")) {
            if (MP3CursorLocationUserReader.UP.equals(s))
                up();
            else if (MP3CursorLocationUserReader.DOWN.equals(s))
                down();
        }
    }
}