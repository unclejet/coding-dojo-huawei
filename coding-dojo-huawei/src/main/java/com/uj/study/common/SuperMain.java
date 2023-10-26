package com.uj.study.common;

import com.uj.study.common.input.LineReader;

import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/10/26 下午12:45
 * @description：
 */
public abstract class SuperMain {
    protected static LineReader lineReader = () -> new Scanner(System.in).nextLine();
}
