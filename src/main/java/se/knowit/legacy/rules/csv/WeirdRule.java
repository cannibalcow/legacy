package se.knowit.legacy.rules.csv;

import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.Rule;
import se.knowit.legacy.rules.RuleResult;

/**
 * From spec: Efternamn får vara null om förnamn börjar på 'A', 'B', 'F'
 */
public class WeirdRule extends Rule<CSVRow> {

    private static final String WEIRDO_RULE_NAME = "Weirdo rule";

    @Override
    public String getRuleName() {
        return WEIRDO_RULE_NAME;
    }

    @Override
    public RuleResult execute(CSVRow value) {
        if(value.getFirstname() == null) {
            return RuleResult.fail("Required field 'firstname' is null");
        }


        return isWeridoRuleOk(value.getFirstname(), value.getLastname());
    }

    protected RuleResult isWeridoRuleOk(String firstname, String lastname) {
        if(lastname != null) {
            return RuleResult.success();
        }

        char initChar = firstname.toUpperCase().charAt(0);
        if('A' == initChar || 'B' == initChar || 'F' == initChar) {
            return RuleResult.success();
        } else {
            return RuleResult.fail(String.format("Weirdo rule does not match on: firstname: %s & lastname: %s", firstname, lastname));
        }
    }
}
