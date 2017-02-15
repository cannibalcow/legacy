package se.knowit.legacy.parser;

import org.junit.Test;
import se.knowit.legacy.Personnummer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CSVRowTest {

    @Test
    public void toCsv() throws Exception {
        Personnummer persnr = new Personnummer();
        persnr.setPersonnummer("19820930-1234");

        CSVRow row = new CSVRow("daniel", "heldt", persnr, "fake@email.com");
        assertThat(row.toCsv(), is("daniel;heldt;19820930-1234;fake@email.com"));
    }
}