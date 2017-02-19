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
import se.knowit.legacy.service.CSVRowDataService;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Legacy {

    private static final Long MATURE_YEAR = 1600L;

    public static void main(String[] args) throws CSVParseException {
        String file = args[0];
        CSVFileParser fp = new CSVFileParser();
        // Parse file
        List<CSVRow> csv = fp.parse(Paths.get(file), ";");

        // Create rule engine
        RuleEngine<CSVRow> engine = new RuleEngine<>(Arrays.asList(new EmailRule(), new PersonnummerRule(), new WeirdRule()));

        // Run on all csvrows
        List<List<RuleResult>> ruleResults = csv.stream().map(engine::runOn).collect(Collectors.toList());

        if (RuleTools.hasRuleErrors(ruleResults)) {
            RuleTools.printRuleSummery(ruleResults);
            return;
        }

        // Finally print out minors
        CSVRowDataService csvService = new CSVRowDataService(csv);

        System.out.println("\n\nRESULTAT");
        csvService.fetchMinors(MATURE_YEAR).forEach(m -> System.out.println(m.toCsv()));
    }
}
