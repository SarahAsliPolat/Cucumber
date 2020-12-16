package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EmreStepDefs {
    public static String tempInput;

    @Given("I logged in Emre")
    public void iLoggedInEmre() throws Exception {
        PageObjectMgr.setCurrentPage("EmrePage");
        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHireButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");

        loadLogin.click();
        Thread.sleep(1000);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();
        WebElement wait = new WebDriverWait(Driver.getDriver(), 6).until(ExpectedConditions.visibilityOf(newHireButton));
        ScenarioManager.getScenario().write("I logged in");
    }

    @When("I click on {string} as Emre")
    public void iClickOnAsEmre(String element) {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
        clickElement.click();
    }

    @When("I type {string} in {string}")
    public void iTypeIn(String value, String element) throws Exception {
        tempInput = value.toLowerCase();
        WebElement editElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
        try {
            editElement.click();
        } catch (Exception e) {
            editElement.sendKeys(Keys.RETURN);
        }
        try {
            editElement.clear();
            editElement.sendKeys(value);
            ScenarioManager.getScenario().write("Entered value " + value + " in " + element);
        } catch (Exception e) {
            throw new Exception("Unable to enter value " + value + " in " + element + "; Error encountered:" + e.getMessage());
        }

    }

    @Then("I get the {string} as a list and validate")
    public void iGetTheAsAListAndValidate(String value) throws Exception {
        List<WebElement> searchResult = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), value);

        String expectedValue;

        for (int i = 0; i < searchResult.size(); i++) {
            expectedValue = searchResult.get(i).getText().toLowerCase();

            if (!expectedValue.contains(tempInput)) {
                throw new Exception("Fail; \n Expected: " + tempInput + " \n Found : " + expectedValue);
            } else {
                System.out.println("Pass; \n Expected: " + tempInput + " \n Found : " + searchResult.get(i).getText());
            }
        }
        System.out.println("Total number of search results: " + searchResult.size());
    }
}