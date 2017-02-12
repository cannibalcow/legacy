package se.knowit.legacy.rules.csv;

import org.junit.Before;
import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.RuleResult;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class PersonnummerRuleTest {
    private PersonnummerRule rule;
    private Personnummer personnummer;
    private CSVRow testrow;

    @Before
    public void setup() {
        rule = new PersonnummerRule();
        personnummer = new Personnummer();
        personnummer.setPersonnummer("16820930-1234");
        testrow = new CSVRow("Daniel", "Heldt", personnummer, "email@server.com");
    }

    @Test
    public void getRuleName() throws Exception {
        assertThat("Personnummer rule", is(rule.getRuleName()));
    }

    @Test
    public void executeValidTest() throws Exception {
        RuleResult result = rule.execute(testrow);
        assertThat(result.isSuccess(), is(true));
        assertThat(result.getMessage(), is(nullValue()));
    }

    @Test
    public void executeInvalidNullTest() {
        testrow.setPersonnummer(null);
        RuleResult result = rule.execute(testrow);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("Personnummer null"));
    }

    @Test
    public void executeInvalidLengthTest() {
        testrow.getPersonnummer().setPersonnummer("16210920-123");
        RuleResult result = rule.execute(testrow);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(), is("Personnummer is not valid: 16210920-123"));
    }

}