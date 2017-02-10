package se.knowit.legacy.rules;

import se.knowit.legacy.parser.CSVRow;

public abstract class Rule {
    abstract String getRuleName();
    abstract boolean execute(CSVRow csvRow);
}
