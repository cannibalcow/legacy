package se.knowit.legacy;

import se.knowit.legacy.parser.CSVFileParser;
import se.knowit.legacy.parser.CSVParseException;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.RuleEngine;
import se.knowit.legacy.rules.RuleResult;
import se.knowit.legacy.rules.RuleTools;
import se.knowit.legacy.rules.csv.EmailRule;
import se.knowit.legacy.rules.csv.PersonnummerRule;
import se.knowit.legacy.rules.csv.WeirdRule;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Legacy2 {

    public static void main(String[] args) throws CSVParseException {
        CSVFileParser fp = new CSVFileParser();
        // Parse file
        List<CSVRow> csv = fp.parse(Paths.get("/Users/heldt/Documents/code/legacy/src/main/resources/bad-file.csv"), ";");
        System.out.println(csv.size());

        // Create rule engine
        RuleEngine<CSVRow> engine = new RuleEngine<>(Arrays.asList(new EmailRule(), new PersonnummerRule(), new WeirdRule()));

        // Run on all csvrows
        List<List<RuleResult>> ruleResults = csv.stream().map(engine::runOn).collect(Collectors.toList());

        if(RuleTools.hasRuleErrors(ruleResults)) {
            RuleTools.printRuleSummery(ruleResults);
            return;
        }



    }
}
