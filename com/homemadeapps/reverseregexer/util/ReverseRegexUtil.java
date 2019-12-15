package com.homemadeapps.reverseregexer.util;

import java.util.regex.Pattern;

public class ReverseRegexUtil {

    public ReverseRegexUtil(final RegexReplacer regexReplacer) {
        this.regexReplacer = regexReplacer;
    }

    /**
     * Generates a regex string for given input text.
     * @param inputText
     * @return
     */
    public String generateRegex(final String inputText) {
        // ToDo - use more optimized append
        final StringBuilder generatedRegex = new StringBuilder();
        for (char inputTextCharacter: inputText.toCharArray()) {
            generatedRegex.append(regexReplacer.findRegexReplacementForCharacter(inputTextCharacter));
        }

        return generatedRegex.toString();
    }

    /**
     * Checks if given regex matches the given text.
     * @param inputText
     * @return
     */
    public boolean regexMatches(final String regex, final String inputText) {
        return Pattern.compile(regex).matcher(inputText).matches();
    }

    private RegexReplacer regexReplacer;

}
