package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "not @ui,@api",
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json", "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"steps"},
        publish = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
