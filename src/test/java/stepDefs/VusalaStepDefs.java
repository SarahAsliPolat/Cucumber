package stepDefs;

import PageFactory.VusalaPage;
import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VusalaStepDefs {
    WebDriver driver = Driver.getDriver();

    @Given("I logged in Vusala")
    public void iLoggedInVusala() throws Exception {
        PageObjectMgr.setCurrentPage("VusalaPage");

        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTexBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHire = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");
        WebElement saveBut = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "saveButton");

        loadLogin.click();
        Thread.sleep(1000);
        emailTexBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();

        WebElement wait = new WebDriverWait(Driver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(newHire));
        ScenarioManager.getScenario().write("I logged in");


    }

    @When("I run the test")
    public void iRunTheTest() {
    }

    @When("I click on {string} as Vusala")
    public void iClickOnAsVusala(String element) {

        WebElement ClickElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(),element);

        ClickElement.click();

    }

   @Then("I clicked on {string}")
    public void iClickedOn(String element) {
        WebElement ClickElement = (WebElement) WebElementMgr.
               getWebElement(PageObjectMgr.getCurrentPage(),element);

       ClickElement.click();
    }

    @And("I validate {string} message is displayed")
    public void iValidateMessageIsDisplayed(String message) throws Exception {

        String locator="//*[contains(text(),'"+message+"')]";

            String actual= driver.findElement(By.xpath(locator)).getText();
            String expected=message;
            Assert.assertEquals(actual,expected,"are not equal");
        }


    }