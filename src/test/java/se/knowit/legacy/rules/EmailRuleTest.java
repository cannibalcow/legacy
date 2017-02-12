package se.knowit.legacy.rules;

import org.junit.Before;
import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;

import static org.hamcrest.Matchers.is;
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
        assertThat(rule.execute(validRow), is(false));
    }

    @Test
    public void executeValidTest() throws Exception {
        assertThat(rule.execute(validRow), is(true));
    }

    @Test
    public void exeucteInvalidTest() {
        validRow.setEmail("invalidos-emailos");
        assertThat(rule.execute(validRow), is(false));
    }
}