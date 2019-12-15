package com.homemadeapps.reverseregexer.util.regexReplacementStrategies;

import com.homemadeapps.reverseregexer.util.RandomnessUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import static com.homemadeapps.reverseregexer.util.Constants.*;
import static com.homemadeapps.reverseregexer.util.RegexWildcards.*;

public class RangeStrategy {

    private static final int ADD_RANDOM_CHARACTER_THRESHOLD = 20;

    public static RegexReplacementStrategy RANGE_STRATEGY = string -> getRange(string); // e -> .
    public static RegexReplacementStrategy RANGE_OPTIONAL_STRATEGY = string -> getRange(string) + OPTIONAL; // e -> .?;
    public static RegexReplacementStrategy RANGE_ATLEAST_ONE_STRATEGY = string -> getRange(string) + ATLEAST_ONE; // e -> .+;
    public static RegexReplacementStrategy RANGE_ATLEAST_ZERO_STRATEGY = string -> getRange(string) + ATLEAST_ZERO; // e -> .*;


    private static String getRange(final String string) {
        final List<Character> characters = new ArrayList<>();
        for (char character: string.toCharArray()) {
            characters.add(character);
        }

        final String randomRegex;
        int treatment = RandomnessUtils.getRandomTreatment(2);
        if (treatment == 1) {
            randomRegex = getCharSetRange(characters);
        }
        else {
            randomRegex = getFromToRange(characters);
        }
        return String.format("[%s]", randomRegex);
    }

    public static String getFromToRange(final List<Character> characters) {
        //if (characters.size() == 1) return String.valueOf(characters.get(0));

        char minDigit = 127, maxDigit = 0;
        char minLowerCase = 127, maxLowerCase = 0;
        char minUpperCase = 127, maxUpperCase = 0;

        final List<String> fromToList = new ArrayList<>();
        for (Character character: characters) {
            if (Character.isDigit(character)) {
                if (character < minDigit) {
                    minDigit = character;
                }
                if (character > maxDigit) {
                    maxDigit = character;
                }
            }
            else if (Character.isLowerCase(character)) {
                if (character < minLowerCase) {
                    minLowerCase = character;
                }
                if (character > maxLowerCase) {
                    maxLowerCase = character;
                }
            }
            else if (Character.isUpperCase(character)) {
                if (character < minUpperCase) {
                    minUpperCase = character;
                }
                if (character > maxUpperCase) {
                    maxUpperCase = character;
                }
            }
            else {
                fromToList.add(String.valueOf(character));
            }
        }

        final String fromToFormatString = "%c-%c";

        if ((minDigit <= DIGIT_ASCII_MAX && maxDigit >= DIGIT_ASCII_MIN)
                || RandomnessUtils.getRandomTreatment(20) == 3) {
            // There was a digit in given input, or we're adding a random noise. Add that to regex
            if (minDigit < DIGIT_ASCII_MIN || minDigit > DIGIT_ASCII_MAX) {
                minDigit = RandomnessUtils.randomize(DIGIT_ASCII_MIN, DIGIT_ASCII_MAX);
            }
            if (maxDigit > DIGIT_ASCII_MAX || maxDigit < minDigit) {
                maxDigit = RandomnessUtils.randomize(minDigit, DIGIT_ASCII_MAX);
            }

            final int someDigitLesserThanNeededMinDigit = RandomnessUtils.randomize(DIGIT_ASCII_MIN, minDigit);
            final int someDigitGreaterThanNeededMaxDigit = RandomnessUtils.randomize(maxDigit, DIGIT_ASCII_MAX);

            fromToList.add(String.format(fromToFormatString,
                    someDigitLesserThanNeededMinDigit, someDigitGreaterThanNeededMaxDigit));
        }

        if ((minLowerCase <= LOWER_CASE_ALPHABETS_ASCII_MAX && maxLowerCase >= LOWER_CASE_ALPHABETS_ASCII_MIN)
                || RandomnessUtils.getRandomTreatment(20) == 3) {
            // There was a lower case alphabet in given input, or we're adding a random noise. Add that to regex
            if (minLowerCase < LOWER_CASE_ALPHABETS_ASCII_MIN || minLowerCase > LOWER_CASE_ALPHABETS_ASCII_MAX) {
                minLowerCase = RandomnessUtils.randomize(LOWER_CASE_ALPHABETS_ASCII_MIN, LOWER_CASE_ALPHABETS_ASCII_MAX);
            }
            if (maxLowerCase > LOWER_CASE_ALPHABETS_ASCII_MAX || maxLowerCase < minLowerCase) {
                maxLowerCase = RandomnessUtils.randomize(minLowerCase, LOWER_CASE_ALPHABETS_ASCII_MAX);
            }

            final int someLowerCaseAlphabetLesserThanNeededMinLowerCase =
                    RandomnessUtils.randomize(LOWER_CASE_ALPHABETS_ASCII_MIN, minLowerCase);
            final int someLowerCaseAlphabetGreaterThanNeededMaxLowerCase =
                    RandomnessUtils.randomize(maxLowerCase, LOWER_CASE_ALPHABETS_ASCII_MAX);

            fromToList.add(String.format(fromToFormatString,
                    someLowerCaseAlphabetLesserThanNeededMinLowerCase, someLowerCaseAlphabetGreaterThanNeededMaxLowerCase));
        }

        if ((minUpperCase <= UPPER_CASE_ALPHABETS_ASCII_MAX && maxUpperCase >= UPPER_CASE_ALPHABETS_ASCII_MIN)
                || RandomnessUtils.getRandomTreatment(1) == 1) {
            // There was a upper case alphabet in given input, or we're adding a random noise. Add that to regex
            if (minUpperCase < UPPER_CASE_ALPHABETS_ASCII_MIN || minUpperCase > UPPER_CASE_ALPHABETS_ASCII_MAX) {
                minUpperCase = RandomnessUtils.randomize(UPPER_CASE_ALPHABETS_ASCII_MIN, UPPER_CASE_ALPHABETS_ASCII_MAX);
            }
            if (maxUpperCase > UPPER_CASE_ALPHABETS_ASCII_MAX || maxUpperCase < minUpperCase) {
                maxUpperCase = RandomnessUtils.randomize(minUpperCase, UPPER_CASE_ALPHABETS_ASCII_MAX);
            }

            final int someUpperCaseAlphabetLesserThanNeededMinUpperCase =
                    RandomnessUtils.randomize(UPPER_CASE_ALPHABETS_ASCII_MIN, minUpperCase);
            final int someUpperCaseAlphabetGreaterThanNeededMaxUpperCase =
                    RandomnessUtils.randomize(maxUpperCase, UPPER_CASE_ALPHABETS_ASCII_MAX);

            fromToList.add(String.format(fromToFormatString,
                    someUpperCaseAlphabetLesserThanNeededMinUpperCase, someUpperCaseAlphabetGreaterThanNeededMaxUpperCase));
        }

        Collections.shuffle(fromToList);

        final StringBuilder randomFromToRange = new StringBuilder();
        fromToList.forEach(randomFromToRange::append);

        return randomFromToRange.toString();
    }

    private static String getCharSetRange(final List<Character> characters) {
        Collections.shuffle(characters);
        final StringBuilder randomCharsetRange = new StringBuilder();

        for (Character character: characters) {
            randomCharsetRange.append(character);
        }

        randomCharsetRange.append(RandomnessUtils.getRandomAlphaNumericCharacter(ADD_RANDOM_CHARACTER_THRESHOLD));
        //ToDo - add random range

        return randomCharsetRange.toString();
    }


}
