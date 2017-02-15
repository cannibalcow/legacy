package se.knowit.legacy.rules;

import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.csv.EmailRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleToolsTest {

    @Test
    public void hasErrorsTest() {
        List<RuleResult> r1 = Arrays.asList(RuleResult.fail("fail"), RuleResult.success());
        List<RuleResult> r2 = Arrays.asList(RuleResult.success(), RuleResult.success());
        List<List<RuleResult>> rr = Arrays.asList(r1, r2);

        assertThat(RuleTools.hasRuleErrors(rr), is(true));
    }

    @Test
    public void hasOnlySuccessTest() {
        List<RuleResult> r1 = Arrays.asList(RuleResult.success(), RuleResult.success());
        List<RuleResult> r2 = Arrays.asList(RuleResult.success(), RuleResult.success());
        List<List<RuleResult>> rr = Arrays.asList(r1, r2);

        assertThat(RuleTools.hasRuleErrors(rr), is(false));
    }

    @Test
    public void printSummaryTest() {
        Personnummer persnr = new Personnummer();
        persnr.setPersonnummer("19820930-1234");
        CSVRow invalidRow = new CSVRow("Daniel", "Heldt", persnr, "server.com");
        EmailRule er = new EmailRule();
        RuleResult ruleResult = er.execute(invalidRow);

        // http://i2.kym-cdn.com/photos/images/newsfeed/000/717/428/c6e.jpg
        ByteArrayOutputStream resultOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(resultOutput);
        System.setOut(ps);

        List<List<RuleResult>> rr = Arrays.asList(Arrays.asList(ruleResult));
        RuleTools.printRuleSummery(rr);

        String output = resultOutput.toString();

        assertThat(output, is("Error: Email did not match rule: server.com @ Daniel;Heldt;19820930-1234;server.com\n"));
    }

}