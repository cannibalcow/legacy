package se.knowit.legacy.service;

import org.junit.Test;
import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CSVRowDataServiceTest {

    @Test
    public void getMinors() throws Exception {
        List<CSVRow> data = Arrays.asList(rowWithPersNr("16040203-1234"),
                rowWithPersNr("16200930-1234"), rowWithPersNr("16030204-1234"));
        CSVRowDataService service = new CSVRowDataService(data);

        List<CSVRow> minors = service.fetchMinors(1600L);

        assertThat(minors.size(), is(2));
        assertThat(minors.get(0).getPersonnummer().getPersonnummer(), is("16040203-1234"));
        assertThat(minors.get(1).getPersonnummer().getPersonnummer(), is("16030204-1234"));
    }

    @Test
    public void isMinor() {
        Personnummer persnr = new Personnummer();
        persnr.setPersonnummer("16010101-1234");
        assertThat(CSVRowDataService.isMinor(1600L, persnr), is(true));

        persnr.setPersonnummer("16660101-1234");
        assertThat(CSVRowDataService.isMinor(1600L, persnr), is(false));
    }

    private CSVRow rowWithPersNr(String personnummer) {
        Personnummer pers = new Personnummer();
        pers.setPersonnummer(personnummer);
        return new CSVRow("john", "doe", pers, "email@gmail.com");
    }
}