package com.uj.study.study_english;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/1/20 上午8:43
 * @description：
 */
public class NumberHandlerFactory {
    private static final NumberHandlerFactory instance = new NumberHandlerFactory();
    private NumberHandlerFactory() {
    }

    public static NumberHandlerFactory getInstance() {
        return instance;
    }

    public NumberHandler getNumberHandler(int numbersLength) {
        if (numbersLength == 1) {
            return new OneNumberHandler();
        }
        if (numbersLength == 2) {
            return new TwoNumbersHandler();
        }
        if (numbersLength == 3) {
            return new ThreeNumbersHandler();
        }
        if (numbersLength >=4  && numbersLength < 7)
            return new Four2SixNumberHandler();
        if (numbersLength >=7 && numbersLength < 10)
            return new Seven2NineNumberHandler();
        if (numbersLength >=10 && numbersLength < 13)
            return new Ten2TwelveNumberHandler();
        return null;
    }
}
