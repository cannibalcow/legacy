package se.knowit.legacy.stepdef;

import cucumber.api.DataTable;
import cucumber.api.java.sv.Givet;
import cucumber.api.java.sv.När;
import se.knowit.legacy.Legacy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LegacyStepdef {
    public static final String DT_FORNAMN = "fornamn";
    public static final String DT_EFTERNAMN = "efternamn";
    public static final String DT_PERSONNUMMER = "personnummer";
    public static final String DT_EPOST = "epost";
    public static final String FILE_HEADER = "firstname;lastname;personal_number;email";
    public static final String NEW_LINE = "\n";

    private Map<String, Object> objAlias = new HashMap<>();

    @Givet("^att i filen '(.+)' finns följande rader$")
    public void attIFilenFilFinnsFöljandeRader(String filnamn, DataTable dataTable) throws IOException {
        File tmpFile = File.createTempFile(filnamn, ".csv");
        Path filePath = Paths.get(tmpFile.getAbsolutePath());

        // Write header
        Files.write(filePath, FILE_HEADER.concat(NEW_LINE).getBytes());

        dataTable.asMaps(String.class, String.class).forEach(row -> {
            String line = toCsvString(";", row.get(DT_FORNAMN), row.get(DT_EFTERNAMN), row.get(DT_PERSONNUMMER), row.get(DT_EPOST));
            try {
                Files.write(filePath, line.concat(NEW_LINE).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        objAlias.put(filnamn, tmpFile.getAbsolutePath());
    }

    @När("^legacy kör med fil '(.+)' få vi resultatet$")
    public void legacyKörMedFilFilFåViResultatet(String filnamn, DataTable dataTable) throws Throwable {
        String filPath = (String) objAlias.get(filnamn);

        // OH NOES!! System.out evil caputre device sucking soul out of developer
        ByteArrayOutputStream resultOutput = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(resultOutput);
        System.setOut(ps);

        // Kör legacy
        Legacy.main(new String[]{filPath});

        assertThat(resultOutput.toString().contains("RESULTAT\nDaniel;Heldt;16100930-1234;daniel@email.com"), is(true));
    }

    public String toCsvString(String delimiter, String... cols) {
        return Arrays.stream(cols).reduce((k, v) -> k.concat(";").concat(v)).get();
    }
}
