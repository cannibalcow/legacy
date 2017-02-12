package se.knowit.legacy.rules;

import java.util.List;
import java.util.stream.Collectors;

public class RuleEngine<T> {
    private List<Rule<T>> rules;

    public RuleEngine(List<Rule<T>> rules) {
        this.rules = rules;
    }

    public List<RuleResult> runOn(T object) {
        return rules.stream().map(tRule -> tRule.execute(object)).collect(Collectors.toList());
    }
}
