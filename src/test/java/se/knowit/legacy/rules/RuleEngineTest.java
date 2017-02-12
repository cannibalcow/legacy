package se.knowit.legacy.rules;

import org.junit.Before;
import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;
import se.knowit.legacy.rules.csv.EmailRule;
import se.knowit.legacy.rules.csv.PersonnummerRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class RuleEngineTest {

    private RuleEngine<CSVRow> engine;
    private CSVRow rowA;
    private CSVRow rowB;

    @Before
    public void setUp() throws Exception {
        EmailRule emailRule = new EmailRule();
        PersonnummerRule personnummerRule = new PersonnummerRule();
        engine = new RuleEngine<>(Arrays.asList(emailRule, personnummerRule));
        Personnummer persnr = new Personnummer();
        persnr.setPersonnummer("16480202-1345");
        rowA = new CSVRow("daniel", "heldt", persnr, "valid@email.com");
        rowB = new CSVRow("balong", "ojoj", persnr, "invalid");
    }

    @Test
    public void runOnRowASuccessTest() {
        List<RuleResult> result = engine.runOn(rowA);

        assertThat(result.size(), is(2));

        RuleResult resA = result.get(0);
        assertThat(resA.isSuccess(), is(true));
        assertThat(resA.getMessage(), is(nullValue()));

        RuleResult resB = result.get(1);
        assertThat(resB.isSuccess(), is(true));
        assertThat(resB.getMessage(), is(nullValue()));
    }

    @Test
    public void runonRowBFailTest() {
        List<RuleResult> result = engine.runOn(rowB);

        assertThat(result.size(), is(2));

        RuleResult resA = result.get(0);
        assertThat(resA.isSuccess(), is(false));
        assertThat(resA.getMessage(), is("Email did not match rule: invalid"));

        RuleResult resB = result.get(1);
        assertThat(resB.isSuccess(), is(true));
        assertThat(resB.getMessage(), is(nullValue()));
    }
}