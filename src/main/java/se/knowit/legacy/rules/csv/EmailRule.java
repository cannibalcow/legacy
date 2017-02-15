package se.knowit.legacy.rules.csv;


import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.Rule;
import se.knowit.legacy.rules.RuleResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates email on @CSVRow
 */
public class EmailRule extends Rule<CSVRow> {
    private static final String EMAIL_RULE_NAME = "Email rule";
    private Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    @Override
    public String getRuleName() {
        return EMAIL_RULE_NAME;
    }

    @Override
    public RuleResult execute(CSVRow value) {
        if(value.getEmail() == null) {
            return RuleResult.fail("Email is null");
        }

        Matcher matcher = pattern.matcher(value.getEmail());

        if(matcher.matches()) {
            return RuleResult.success();
        } else {
            return RuleResult.fail("Email did not match rule: "+ value.getEmail(), value.toCsv());
        }
    }
}
