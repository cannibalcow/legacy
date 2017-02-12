package se.knowit.legacy.rules.csv;

import org.junit.Before;
import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.RuleResult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class WeirdRuleTest {

    private WeirdRule rule;
    private CSVRow validCommonRow;

    @Before
    public void setUp() throws Exception {
        rule = new WeirdRule();
        Personnummer persnr = new Personnummer();
        persnr.setPersonnummer("16020323-1234");
        validCommonRow = new CSVRow("daniel", "heldt", persnr, "fake@email.com");
    }

    @Test
    public void getRuleName() throws Exception {
        assertThat(rule.getRuleName(), is("Weirdo rule"));
    }

    @Test
    public void executeRowTest() throws Exception {
        RuleResult result = rule.execute(validCommonRow);
        assertThat(result.isSuccess(), is(true));
        assertThat(result.getMessage(), is(nullValue()));
    }

    @Test
    public void executeOnInvalidFirstnameTest() {
        validCommonRow.setFirstname(null);
        RuleResult result = rule.execute(validCommonRow);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessage(),is("Required field 'firstname' is null"));
    }

    @Test
    public void isWeridoRuleOk() throws Exception {
        assertThat(rule.isWeridoRuleOk("Bengt", null).isSuccess(), is(true));
        assertThat(rule.isWeridoRuleOk("Fredrik", null).isSuccess(), is(true));
        assertThat(rule.isWeridoRuleOk("Apa", null).isSuccess(), is(true));
        assertThat(rule.isWeridoRuleOk("Prips", null).isSuccess(), is(false));
        assertThat(rule.isWeridoRuleOk("Apa", "Balong").isSuccess(), is(true));
    }


}