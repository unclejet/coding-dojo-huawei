package com.uj.study.game_24_point;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/1/31 下午12:48
 * @description：
 */
public class PairGroup {
    private Group group1;
    private Group group2;

    public PairGroup(Group group1, Group group2) {
        this.group1 = group1;
        this.group2 = group2;
    }

    public boolean has24() {
        int[] v1 = group1.getValues();
        int[] v2 = group2.getValues();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (v1[i] + v2[j] == 24 ||
                        (v1[i] - v2[j] == 24 || v2[j] - v1[i] == 24) ||
                        v1[i] * v1[j] == 24 ||
                        ((v2[j] > 0 && v1[i] / v2[j] == 24) || (v1[i] > 0 && v2[j] / v1[i] == 24))
                )
                    return true;
            }
        }
        return false;
    }

    public Group getGroup1() {
        return group1;
    }

    public Group getGroup2() {
        return group2;
    }
}
