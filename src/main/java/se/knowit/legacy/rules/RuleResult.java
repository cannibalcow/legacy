package se.knowit.legacy.rules;

public class RuleResult {
    private boolean success;
    private String message;

    private RuleResult() {
    }

    public RuleResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static RuleResult success() {
        return new RuleResult(true, null);
    }

    public static RuleResult fail(String message) {
        return new RuleResult(false, message);
    }

    public boolean isSuccess() {
        return success;
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
