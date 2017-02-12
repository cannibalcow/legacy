package se.knowit.legacy.rules.csv;

import org.junit.Before;
import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.RuleResult;
import se.knowit.legacy.rules.csv.EmailRule;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class EmailRuleTest {

    private EmailRule rule;
    private CSVRow validRow;
    private Personnummer personnummer;

    @Before
    public void setup() {
        rule = new EmailRule();
        personnummer = new Personnummer();
        personnummer.setPersonnummer("19820930-1234");
        validRow = new CSVRow("Daniel", "Heldt", personnummer, "email@server.com");
    }

    @Test
    public void getRuleNameTest() throws Exception {
        assertThat(rule.getRuleName(), is("Email rule"));
    }

    @Test
    public void executeNullValueTest() {
        validRow.setEmail(null);
        RuleResult result = rule.execute(validRow);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("Email is null"));
    }

    @Test
    public void executeValidTest() throws Exception {
        RuleResult result = rule.execute(validRow);
        assertThat(result.isSuccess(), is(true));
        assertThat(result.getMessage(), is(nullValue()));
    }

    @Test
    public void exeucteInvalidTest() {
        String invalidMail = "invalidos-emailos";
        validRow.setEmail(invalidMail);
        RuleResult result = rule.execute(validRow);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is( "Email did not match rule: " + invalidMail));

    }
}