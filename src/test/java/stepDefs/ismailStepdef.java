package stepDefs;

import PageFactory.IsmailPage;
import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ismailStepdef {

    @Given("I am on the {string} as ismail")
    public void i_am_on_the_as_ismail(String pageNm) throws Exception {
        PageObjectMgr.setCurrentPage(pageNm);
        ScenarioManager.getScenario().write("User is on " + pageNm + " page");
    }

    @When("I wait for {string} to be {string} as ismail")
    public void i_wait_for_to_be_as_ismail(String elementNm, String state) {
        WebElement waitElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), 6).
                pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        if (state.equals("visible"))
            wait.until(ExpectedConditions.visibilityOf(waitElement));
        else
            wait.until(ExpectedConditions.elementToBeClickable(waitElement));
    }

    @Then("I click on {string} as ismail")
    public void i_click_on_as_ismail(String elementNm) throws Exception {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);

        try {
            clickElement.click();
            ScenarioManager.getScenario().write("Clicked on " + elementNm);
        } catch (Exception e) {
            throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }



    @Then("I enter {string} in {string} as ismail")
    public void i_enter_in_as_ismail(String value, String elementNm) throws Exception {
        WebElement editElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        try {
            editElement.click();
        } catch (Exception e) {
            editElement.sendKeys(Keys.RETURN);
        }
        try {
            editElement.clear();
            editElement.sendKeys(value);
            ScenarioManager.getScenario().write("Entered value " + value + " in " + elementNm);
        } catch (Exception e) {
            throw new Exception("Unable to enter value " + value + " in " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }

    @Then("I wait for {string} milliseconds as ismail")
    public void witingmement(String waitTime) throws Exception {
        Thread.sleep(Long.parseLong(waitTime));
        ScenarioManager.getScenario().write("Waited for " + waitTime + " milliseconds");
    }
    @Then("I Validate the jobFilterList drop down list has these below as ismail")
    public void i_Validate_the_jobFilterList_drop_down_list_has_these_below_as_ismail(List<String> expectedList ) throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"Texts" );

        String expectedValue;
        String actualValue;

        for (int i = 0; i < expectedList.size() ; i++) {
            expectedValue = expectedList.get(i);
            actualValue = actualList.get(i).getText();
            if (!actualValue.equals(expectedValue)) {
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }

}