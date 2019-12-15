package com.homemadeapps.reverseregexer.util.regexReplacementStrategies;

import static com.homemadeapps.reverseregexer.util.RegexWildcards.*;

public class DittoStrategy {
    public static RegexReplacementStrategy DITTO_STRATEGY = String::valueOf; // e -> e
    public static RegexReplacementStrategy DITTO_OPTIONAL_STRATEGY = string -> string + OPTIONAL; // e -> e?;
    public static RegexReplacementStrategy DITTO_ATLEAST_ONE_STRATEGY = string -> string + ATLEAST_ONE; // e -> e+;
    public static RegexReplacementStrategy DITTO_ATLEAST_ZERO_STRATEGY = string -> string + ATLEAST_ZERO; // e -> e*;
}
