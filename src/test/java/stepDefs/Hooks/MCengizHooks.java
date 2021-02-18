package stepDefs.Hooks;

import Utilities.Constants;
import Utilities.Driver;
import Utilities.ScenarioManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MCengizHooks {

    @Before("@SDMA1")
    public void beforeTest(Scenario scenario) {
        System.out.println("Before Testtttt");
    }

    @After("@SDMA1")
    public void afterTest(Scenario scenario) {
        System.out.println("After Testtttt");
    }
}
