package se.knowit.legacy.parser;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by heldt on 2017-02-02.
 */
public class CSVFileParserTest {

    private CSVFileParser parser;

    @Before
    public void setup() {
        parser = new CSVFileParser();
    }


    @Test
    public void parseTest() throws Exception {
        Path file = Paths.get(getClass().getClassLoader().getResource("good-small-file.csv").getPath());
        List<CSVRow> result = parser.parse(file, ";");

        assertThat(result.size(), is(4));

        CSVRow firstRow = result.get(0);

        assertThat(firstRow.getFirstname(), is("Vaughan"));
        assertThat(firstRow.getLastname(), is("Stafford"));
        assertThat(firstRow.getPersonnummer().getPersonnummer(), is("16290828-0361"));
        assertThat(firstRow.getEmail(), is("Nunc@ipsum.net"));
    }

    @Test
    public void parseRowTest() {
        CSVRow rad = parser.mapRad("Vaughan;Stafford;16290828-0361;Nunc@ipsum.net", ";");
        assertThat(rad.getFirstname(), is("Vaughan"));
        assertThat(rad.getLastname(), is("Stafford"));
        assertThat(rad.getPersonnummer().getPersonnummer(), is("16290828-0361"));
        assertThat(rad.getEmail(), is("Nunc@ipsum.net"));
    }


}