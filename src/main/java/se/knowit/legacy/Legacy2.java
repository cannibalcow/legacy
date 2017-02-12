package se.knowit.legacy;

import se.knowit.legacy.parser.CSVFileParser;
import se.knowit.legacy.parser.CSVParseException;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.RuleEngine;
import se.knowit.legacy.rules.RuleResult;
import se.knowit.legacy.rules.csv.EmailRule;
import se.knowit.legacy.rules.csv.PersonnummerRule;
import se.knowit.legacy.rules.csv.WeirdRule;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by heldt on 12/02/17.
 */
public class Legacy2 {

    public static void main(String[] args) throws CSVParseException {
        CSVFileParser fp = new CSVFileParser();
        List<CSVRow> csv = fp.parse(Paths.get("/Users/heldt/Documents/code/legacy/src/main/resources/good-file.csv"), ";");
        System.out.println(csv.size());

        RuleEngine<CSVRow> engine = new RuleEngine<>(Arrays.asList(new EmailRule(), new PersonnummerRule(), new WeirdRule()));


    }
}
