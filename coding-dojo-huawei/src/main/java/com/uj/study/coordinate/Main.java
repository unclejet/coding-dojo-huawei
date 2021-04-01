package com.uj.study.coordinate;

import com.uj.study.common.input.LineReader;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/4/1 上午11:39
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        LineReader lineReader = () -> new Scanner(System.in).nextLine();
        CoordinateUserInputReader inputReader = new CoordinateUserInputReader(lineReader);
        List<String> coordinates = inputReader.readValidCoordinates();
        CoordinatorMoving moving = new CoordinatorMoving();
        moving.calculate(coordinates);
        System.out.println(String.format("(%d,%d)", moving.getX(), moving.getY()));
    }

}
