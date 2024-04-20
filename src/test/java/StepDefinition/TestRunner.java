package StepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/feature_file",
        plugin = {"pretty","html:target/cucumber.html",
        "json:target/cucumber/cucumber-report.json",
        "junit:target/cucumber.xml"},
        tags = "@OpenCart")

public class TestRunner {
}
