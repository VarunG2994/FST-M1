package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue= {"stepDefinitions"},
    tags= "@activity5",
        plugin = {"pretty",
        "html: target/Cucumber-Report/cucumber.html",
                "json: target/json-report.json"
        },
        monochrome = true
)
public class TestRunner {

}
