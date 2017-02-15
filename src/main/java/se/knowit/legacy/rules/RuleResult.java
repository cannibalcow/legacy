package se.knowit.legacy.rules;

public class RuleResult {
    private boolean success;
    private String message;
    private String details;

    private RuleResult() {
    }

    public RuleResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RuleResult(boolean success, String message, String details) {
        this.success = success;
        this.message = message;
        this.details = details;
    }

    public static RuleResult success() {
        return new RuleResult(true, null);
    }

    public static RuleResult fail(String message) {
        return new RuleResult(false, message);
    }

    public static RuleResult fail(String message, String details) {
        return new RuleResult(false, message, details);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
