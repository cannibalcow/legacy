package se.knowit.legacy.parser;

import se.knowit.legacy.Personnummer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileParser implements CSVParser {

    @Override
    public List<CSVRow> parse(Path path, String delimiter) throws CSVParseException {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(row -> mapRad(row, delimiter))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new CSVParseException(e);
        }
    }

    protected CSVRow mapRad(String row, String delimiter) {
        String[] splitrad = row.split(delimiter);
        Personnummer personnummer = new Personnummer();
        personnummer.setPersonnummer(splitrad[2]);
        return new CSVRow(splitrad[0], splitrad[1], personnummer, splitrad[3]);
    }
}
