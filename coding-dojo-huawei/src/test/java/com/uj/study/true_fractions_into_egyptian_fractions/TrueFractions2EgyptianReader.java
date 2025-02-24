package com.uj.study.true_fractions_into_egyptian_fractions;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.UserInputReader;
import org.apache.commons.lang3.math.Fraction;

public class TrueFractions2EgyptianReader extends UserInputReader {
    public TrueFractions2EgyptianReader(LineReader lineReader) {
        super(lineReader);
    }

    public Fraction readFraction() {
        while (true) {
            String input = lineReader.readLine();
            try {
                String[] parts = input.split("/");
                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);

                if (numerator >= 1 && denominator > numerator && denominator <= 100) {
                    return Fraction.getFraction(numerator, denominator);
                }
            } catch (Exception e) {
                // Ignore and continue to prompt for valid input
            }
        }
    }
}
