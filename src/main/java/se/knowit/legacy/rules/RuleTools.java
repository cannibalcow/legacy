package se.knowit.legacy.rules;

import java.util.List;


public class RuleTools {
    private RuleTools() {
    }


    public static boolean hasRuleErrors(List<List<RuleResult>> ruleResults) {
        long count = ruleResults.stream()
                .flatMap(p -> p.stream().filter(r -> !r.isSuccess())).count();
        return count > 0;
    }

    public static void printRuleSummery(List<List<RuleResult>> ruleResults) {
        ruleResults.stream()
                .flatMap(p -> p.stream().filter(r -> !r.isSuccess()))
                .forEach((RuleResult result) -> System.out.printf("Error: %s @ %s%n", result.getMessage(), result.getDetails()));
    }
}
