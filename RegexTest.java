import com.homemadeapps.reverseregexer.util.ReverseRegexUtil;
import com.homemadeapps.reverseregexer.util.ReverseRegexUtilFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Tester class to test RegexUtil's generateRegex functionality.
 * Uses a list of string to generate regexes for, and tries matching them with generated regexes.
 */
public class RegexTest {

    public static void main(String[] args) {

        List<String> inputStrings = generateInputStrings();
        List<String> mismatches = new ArrayList<>();
        int matches = 0;
        for (int i=0; i<100; i++) {
            for (String string : inputStrings) {
                final String regex = reverseRegexUtil.generateRegex(string);
                final boolean regexMatch = reverseRegexUtil.regexMatches(regex, string);
                //System.out.println(String.format("String: %s produced regex: %s. Whether it matched: %b", string, regex, regexMatch));
                if (!regexMatch) {
                    System.out.println(String.format("Regex: %s for string %s did not match", regex, string));
                }
                else {
                    matches ++;
                }
            }
        }
        System.out.println("Ran all strings. No. of correct matches: " + matches);
    }

    private static List<String> generateInputStrings() {
        final List<String> inputStrings = new ArrayList<>();

        for (int i=0; i<100; i++) {
            inputStrings.add(randomAlphaNumeric(10));
        }

        return inputStrings;
    }

    private static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0abcdefghijklmnopqrstuvwxyz123456789";

    private static ReverseRegexUtil reverseRegexUtil = ReverseRegexUtilFactory.getReverseRegexUtil();
}
