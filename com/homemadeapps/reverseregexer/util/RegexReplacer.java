package com.homemadeapps.reverseregexer.util;

import com.homemadeapps.reverseregexer.util.regexReplacementStrategies.RegexReplacementStrategy;

import java.util.List;

/**
 * Utility class to find a replacement regex string for a given character.
 */
public class RegexReplacer {

    public RegexReplacer(final List<RegexReplacementStrategy> singleCharacterReplacementStrategies) {
        this.singleCharacterReplacementStrategies = singleCharacterReplacementStrategies;
    }

    public String findRegexReplacementForCharacter(final char character) {
        return getRegexUsingStrategies(String.valueOf(character));
    }

    private String getRegexUsingStrategies(final String inputString) {
        if (inputString == null || inputString.length() < 1) {
            return "";
        }
        if (inputString.length() == 1) {
            return getRandomRegexReplacementStrategyForSingleCharacter().apply(inputString);
        }

        throw new RuntimeException("Not yet implemented");
    }

    private RegexReplacementStrategy getRandomRegexReplacementStrategyForSingleCharacter() {
        return singleCharacterReplacementStrategies.get((int)(Math.random() * singleCharacterReplacementStrategies.size()));
    }

    private final List<RegexReplacementStrategy> singleCharacterReplacementStrategies;
}