package se.knowit.legacy.parser;

import se.knowit.legacy.Personnummer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements CSVParser {

    @Override
    public List<CSVRow> parse(File file, String delimiter) throws CSVParseException {
        if (!file.exists()) {
            throw new CSVParseException("filen hittades inte");
        }

        List<CSVRow> rader = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String rad;
            boolean first = true;

            while ((rad = br.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }
                rader.add(mapRad(rad, delimiter));
            }

            br.close();
        } catch (Exception e) {
            throw new CSVParseException(e);
        }

        return rader;
    }

    protected CSVRow mapRad(String rad, String delimiter) {
        String[] splitrad = rad.split(delimiter);
        Personnummer personnummer = new Personnummer();
        personnummer.setPersonnummer(splitrad[2]);
        CSVRow csvRow = new CSVRow(splitrad[0], splitrad[1], personnummer, splitrad[3]);
        return csvRow;
    }
}
