package com.homemadeapps.reverseregexer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.homemadeapps.reverseregexer.util.Constants.*;

public class RandomnessUtils {

    public static String getRandomAlphaNumericCharacter(final int threshold) {
        final StringBuilder randomCharacters = new StringBuilder();
        int shouldAddRandomCharacter = (int)(Math.random() * 100);
        while (shouldAddRandomCharacter < threshold) {
            final List<Character> randomCharactersList = new ArrayList();

            randomCharactersList.add(randomize(DIGIT_ASCII_MIN, DIGIT_ASCII_MAX));
            randomCharactersList.add(randomize(UPPER_CASE_ALPHABETS_ASCII_MIN, UPPER_CASE_ALPHABETS_ASCII_MAX));
            randomCharactersList.add(randomize(LOWER_CASE_ALPHABETS_ASCII_MIN, LOWER_CASE_ALPHABETS_ASCII_MAX));
            Collections.shuffle(randomCharactersList);
            randomCharacters.append(randomCharactersList.get(0));
            shouldAddRandomCharacter = (int)(Math.random() * 100);
        }

        return randomCharacters.toString();
    }

    public static int getRandomTreatment(final int numberOfTreatments) {
        int randomTreatment = (int)((Math.random() * (100))) % numberOfTreatments + 1;
        return randomTreatment;
    }

    public static char randomize(final int min, final int max) {
        return (char)(int)((Math.random() * ((max - min) + 1)) + min);
    }
}
