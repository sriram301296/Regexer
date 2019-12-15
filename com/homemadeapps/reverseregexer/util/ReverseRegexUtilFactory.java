package com.homemadeapps.reverseregexer.util;

import com.homemadeapps.reverseregexer.util.regexReplacementStrategies.RegexReplacementStrategy;

import java.util.List;

public class ReverseRegexUtilFactory {
    private static List<RegexReplacementStrategy> singleCharacterReplacementStrategies =
            RegexReplacementStrategy.getAvailableSingleCharacterReplacementStrategies();
    private static RegexReplacer regexReplacer = new RegexReplacer(singleCharacterReplacementStrategies);

    private static ReverseRegexUtil reverseRegexUtil = new ReverseRegexUtil(regexReplacer);




    public static ReverseRegexUtil getReverseRegexUtil() {
        return reverseRegexUtil;
    }

}
