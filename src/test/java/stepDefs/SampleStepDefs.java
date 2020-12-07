package stepDefs;

import Utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SampleStepDefs {

    @Then("I click on {string}")
    public void iClickOn(String elementNm) throws Exception {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);

        try {
            clickElement.click();
            ScenarioManager.getScenario().write("Clicked on " + elementNm);
        } catch (Exception e) {
            throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }

    @Then("I enter {string} in {string}")
    public void iEnterIn(String value, String elementNm) throws Exception {
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


    @Then("I wait for {string} to be clickable")
    public void iWaitForToBeClickable(String elementNm) {
        WebElement waitElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        WebElement wait = new WebDriverWait(Driver.getDriver(), 6).until(ExpectedConditions.elementToBeClickable(waitElement));
    }

    @Then("I wait for {string} to be visible")
    public void iWaitForToBeVisible(String elementNm) {
        WebElement waitElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        WebElement wait = new WebDriverWait(Driver.getDriver(), 6).until(ExpectedConditions.visibilityOf(waitElement));
    }


    @Then("I validate current page url is {string}")
    public void iValidateCurrentPageUrlIs(String expectedUrl) throws Exception {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        if (!expectedUrl.equals(actualUrl)) {
            throw new Exception(" Fail; \n Expected url: " + expectedUrl + " \n Found url: " + actualUrl);
        } else {
            ScenarioManager.getScenario().write(" Pass; \n Expected url: " + expectedUrl + " \n Found url: " + actualUrl);
        }
    }

    @Then("I wait for {string} milliseconds")
    public void iWaitForMilliseconds(String waitTime) throws InterruptedException {
        Thread.sleep(Long.parseLong(waitTime));
        ScenarioManager.getScenario().write("Waited for " + waitTime + " milliseconds");
    }


    @Given("I am on the {string}")
    public void iAmOnThe(String pageNm) throws Exception {
        PageObjectMgr.setCurrentPage(pageNm);
        ScenarioManager.getScenario().write("User is on " + pageNm + " page");
    }


    @Then("I Validate the jobFilterList drop down list has these below")
    public void iValidateTheJobFilterListDropDownListBelow(List<String> expectedList) throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"jobFilterList" );

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
