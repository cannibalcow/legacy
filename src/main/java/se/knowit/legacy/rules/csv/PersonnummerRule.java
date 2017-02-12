package se.knowit.legacy.rules.csv;

import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.Rule;
import se.knowit.legacy.rules.RuleResult;

import java.util.regex.Pattern;

public class PersonnummerRule extends Rule<CSVRow> {
    private static final String PERSONNUMMER_RULE_NAME = "Personnummer rule";
    private Pattern pattern = Pattern.compile("^(16|17|18|19|20)?[0-9]{6}[-]?[0-9]{4}$");

    @Override
    public String getRuleName() {
        return PERSONNUMMER_RULE_NAME;
    }

    @Override
    public RuleResult execute(CSVRow value) {
        if(value.getPersonnummer() == null || value.getPersonnummer().getPersonnummer() == null) {
            return RuleResult.fail("Personnummer null");
        }

        Personnummer personnummer = value.getPersonnummer();

        boolean match = pattern.matcher(personnummer.getPersonnummer()).matches();

        if(match) {
            return RuleResult.success();
        } else {
            return RuleResult.fail(String.format("Personnummer is not valid: %s", personnummer.getPersonnummer()));
        }
    }
}
