package se.knowit.legacy.parser;

import java.io.File;
import java.util.List;

/**
 * Parse csv
 */
public interface CSVParser {
    /**
     * Reads a csv file and maps it to the CSVRow object
     * @param file
     * @return
     */
    List<CSVRow> parse(File file, String delimiter) throws CSVParseException;
}
