package se.knowit.legacy.parser;

import java.io.File;
import java.util.List;

/**
 * Parse csv
 */
public interface CSVParser {
    /**
     * Läser in csv fil och mappar till objekt
     * @param file
     * @return
     */
    List<CSVRow> parse(File file, String delimiter) throws CSVParseException;
}
