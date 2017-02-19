package se.knowit.legacy.parser;

import java.nio.file.Path;
import java.util.List;

/**
 * Parse csv
 */
public interface CSVParser {
    /**
     * Reads a csv file and maps it to the CSVRow object
     * @param path
     * @return
     */
    List<CSVRow> parse(Path path, String delimiter) throws CSVParseException;
}
