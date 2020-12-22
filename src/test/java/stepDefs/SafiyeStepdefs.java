package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafiyeStepdefs {

    @Given("I logged in as Safiye")
    public void i_logged_in() throws Exception {
        PageObjectMgr.setCurrentPage("LoginPage");

        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHireButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");
        loadLogin.click();
        Thread.sleep(1500);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        passwordTextBox.sendKeys("admin123test");
        loginButton.click();
        Thread.sleep(4000);
        WebElement wait = new WebDriverWait(Driver.getDriver(), 6).until(ExpectedConditions.visibilityOf(newHireButton));
        PageObjectMgr.setCurrentPage("SafiyePage");
    }


    @When("I click on {string} as Safiye")
    public void clickButton(String element) {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "element");
        clickElement.click();
    }

    @Then("I should see the {string} as Safiye")
    public void validation(String button) {
        WebElement visibleElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), button);
        Assert.assertTrue(button+" is not visible ",visibleElement.isDisplayed());

    }
}
