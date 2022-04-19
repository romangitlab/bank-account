package steps;

import config.RestAssuredConfig;
import config.URLConfigs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    @Before("@ui")
    public void setupPortalURL() {
        open(URLConfigs.PORTAL_URL);
    }

    @Before("@api")
    public void setupApiURL() {
        RestAssuredConfig.setupRequestSpecification();
    }

    @After("@ui")
    public void closeBrowser(Scenario scenario) {
        if(scenario.isFailed()) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot(OutputType.BYTES)));
        }

        closeWindow();
    }
}
