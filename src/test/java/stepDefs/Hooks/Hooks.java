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

public class Hooks {


    @Before
    public void setup(Scenario scenario) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        scenario.write("Browser is:" + Constants.BROWSER_NAME);
        scenario.write("Test time: " + timeStamp);
        scenario.write("Test type: " + Constants.TEST_TYPE);
        ScenarioManager.setScenario(scenario);
        if(!Constants.TEST_TYPE.equals("API")){
            Driver.getDriver();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if(!Constants.TEST_TYPE.equals("API")){
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/jpeg", "failure_image");
            }
            Driver.getDriver().quit();
        }
    }
}
