package com.homemadeapps.reverseregexer.util.regexReplacementStrategies;

import com.homemadeapps.reverseregexer.util.RandomnessUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
        final String randomRegex = getCharSetRange(characters);
        return String.format("[%s]", randomRegex);
    }

    private static String getCharSetRange(final List<Character> characters) {
        Collections.shuffle(characters);
        final StringBuilder randomCharsetRange = new StringBuilder();

        for (Character character: characters) {
            randomCharsetRange.append(character);
        }

        randomCharsetRange.append(RandomnessUtils.getRandomCharacter(ADD_RANDOM_CHARACTER_THRESHOLD));
        //ToDo - add random range

        return randomCharsetRange.toString();
    }


}
