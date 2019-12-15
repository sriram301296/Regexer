package com.homemadeapps.reverseregexer.util.regexReplacementStrategies;

import java.util.List;
import java.util.function.Function;

import static com.homemadeapps.reverseregexer.util.regexReplacementStrategies.DittoStrategy.*;
import static com.homemadeapps.reverseregexer.util.regexReplacementStrategies.AnyCharacterStrategy.*;
import static com.homemadeapps.reverseregexer.util.regexReplacementStrategies.RangeStrategy.*;



public interface RegexReplacementStrategy extends Function<String, String> {

    static List<RegexReplacementStrategy> getAvailableSingleCharacterReplacementStrategies() {
        return List.of(DITTO_STRATEGY, DITTO_OPTIONAL_STRATEGY, DITTO_ATLEAST_ONE_STRATEGY, DITTO_ATLEAST_ZERO_STRATEGY,
                ANY_CHARACTER_STRATEGY, ANY_CHARACTER_OPTIONAL_STRATEGY, ANY_CHARACTER_ATLEAST_ONE_STRATEGY, ANY_CHARACTER_ATLEAST_ZERO_STRATEGY,
                RANGE_STRATEGY, RANGE_OPTIONAL_STRATEGY, RANGE_ATLEAST_ONE_STRATEGY, RANGE_ATLEAST_ZERO_STRATEGY);
    }
}
