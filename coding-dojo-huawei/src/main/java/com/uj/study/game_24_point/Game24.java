package com.uj.study.game_24_point;

public class Game24 {
    public Game24() {
    }

    static boolean has24(int[] numbers) {
        PairGroup[] pgs = group(numbers);
        for (int i = 0; i < 3; i++) {
            if (pgs[i].has24())
                return true;
        }
        return false;
    }

    static PairGroup[] group(int[] numbers) {
        PairGroup[] result = new PairGroup[3];
        for (int i = 1; i < numbers.length; i++) {
            Group group1 = new Group(numbers[0], numbers[i]);
            int[] leftNumbers = getLeftNumbers(i);
            Group group2 = new Group(numbers[leftNumbers[0]], numbers[leftNumbers[1]]);
            result[i - 1] = new PairGroup(group1, group2);
        }
        return result;
    }

    static int[] getLeftNumbers(int i) {
        int[] result = new int[2];
        for (int j = 1, idx = 0; j < 4; j++) {
            if (j != i)
                result[idx++] = j;
        }
        return result;
    }
}