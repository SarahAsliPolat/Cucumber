package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs"},

        plugin = {"pretty", "json:target/cucumber.json",
                "html:target/cucumber-html-reports"}
        ,tags = {"@Safiye"}


)
public class SafiyeRunner extends AbstractTestNGCucumberTests {

}