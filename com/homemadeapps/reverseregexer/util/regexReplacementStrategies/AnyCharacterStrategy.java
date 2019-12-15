package com.homemadeapps.reverseregexer.util.regexReplacementStrategies;

import static com.homemadeapps.reverseregexer.util.RegexWildcards.*;

public class AnyCharacterStrategy{
    public static RegexReplacementStrategy ANY_CHARACTER_STRATEGY = string -> ANY_CHARACTER; // e -> .
    public static RegexReplacementStrategy ANY_CHARACTER_OPTIONAL_STRATEGY = string -> ANY_CHARACTER + OPTIONAL; // e -> .?;
    public static RegexReplacementStrategy ANY_CHARACTER_ATLEAST_ONE_STRATEGY = string -> ANY_CHARACTER + ATLEAST_ONE; // e -> .+;
    public static RegexReplacementStrategy ANY_CHARACTER_ATLEAST_ZERO_STRATEGY = string -> ANY_CHARACTER + ATLEAST_ZERO; // e -> .*;
}
