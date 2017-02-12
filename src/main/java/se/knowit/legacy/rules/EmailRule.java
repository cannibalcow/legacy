package se.knowit.legacy.rules;


import se.knowit.legacy.parser.CSVRow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates email on @CSVRow
 *
 */
public class EmailRule extends Rule<CSVRow> {
    private static final String EMAIL_RULE_NAME = "Email rule";
    private Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    @Override
    public String getRuleName() {
        return EMAIL_RULE_NAME;
    }

    @Override
    public boolean execute(CSVRow value) {
        if(value.getEmail() == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(value.getEmail());

        return matcher.matches();
    }
}
