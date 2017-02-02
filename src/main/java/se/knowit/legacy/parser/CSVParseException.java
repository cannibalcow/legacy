package se.knowit.legacy.parser;

/**
 * Created by heldt on 2017-02-02.
 */
public class CSVParseException extends Exception {
    public CSVParseException() {
        super();
    }

    public CSVParseException(String message) {
        super(message);
    }

    public CSVParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CSVParseException(Throwable cause) {
        super(cause);
    }

    protected CSVParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
