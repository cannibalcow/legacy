package se.knowit.legacy.systemtest;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@ignore"}, plugin = {"json:target/cucumber-reports/json_report.json"},
    features = "src/test/resources/features", glue = "se.knowit.legacy.stepdef", snippets = SnippetType.CAMELCASE)
public class CucumberRunner {
}
