package automationTest.utils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@TestScriptDemo",
        features = "src/test/resources/features",
        glue = {"automationTest.steps","automationTest.hooks"},
        plugin = {"pretty" ,"json:target/cucumber.json",
                "html:target/cucumber-report.html"},
        monochrome = true,
        strict = true
)
public class TestRunner {

}
