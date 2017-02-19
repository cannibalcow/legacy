package se.knowit.legacy.service;

import se.knowit.legacy.Personnummer;
import se.knowit.legacy.parser.CSVRow;

import java.util.List;
import java.util.stream.Collectors;

public class CSVRowDataService implements DataService<CSVRow> {

    private static final int MATURE_AGE = 18;
    private List<CSVRow> data;

    public CSVRowDataService(List<CSVRow> data) {
        this.data = data;
    }

    @Override
    public List<CSVRow> fetchMinors(Long year) {
        return data.stream().filter(csvRow -> isMinor(year, csvRow.getPersonnummer())).collect(Collectors.toList());
    }

    public static boolean isMinor(Long year, Personnummer personnummer) {
        Long birthyear = Long.valueOf(personnummer.getPersonnummer().substring(0, 4));
        return birthyear - year < MATURE_AGE;
    }
}
