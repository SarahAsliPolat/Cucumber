package stepDefs;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

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


        loadLogin.click();
        Thread.sleep(500);
        emailTexBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(500);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(500);
        loginButton.click();

        WebElement wait = new WebDriverWait(Driver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(newHire));
        ScenarioManager.getScenario().write("I logged in");

    }

    @When("I click on {string} as Vusala")
    public void iClickOnAsVusala(String element) {
        WebElement ClickElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);

        ClickElement.click();

    }

    @And("I validate {string} message is displayed")
    public void iValidateMessageIsDisplayed(String message) throws Exception {

        String locator = "//*[contains(text(),'" + message + "')]";

        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.assertEquals(actual, message, "are not equal");
    }

    @Then("I enter {string} in the {string} as Vusala")
    public void iEnterInThe(String text, String element) {

        WebElement enterText = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        enterText.sendKeys(text);
    }

    @Then("I select {string} from {string} dropDownList")
    public void iSelectFromDropDown(String option, String element) {
        WebElement dropDown = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Select select = new Select(dropDown);
        select.selectByVisibleText(option);
    }

    @And("I scroll and click to {string} as Vusala")
    public void iScrollToAsVusala(String element) {
        WebElement scrollElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Actions built = new Actions(driver);
        built.moveToElement(scrollElement).click().build().perform();

    }


    @Then("I validate {string} Pop-Up page displayed")
    public void iValidatePopUpPageDisplayed(String element) throws Exception {
        WebElement validateElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertTrue(validateElement.isDisplayed());
    }

    @And("I validate {string} toaster message is displayed")
    public void iValidateToasterMessageIsDisplayed(String element) {

        WebElement validateToaster = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertFalse(validateToaster.getText().isEmpty());
    }


    @Then("I validate {string} text is displayed in {string} dropDown list")
    public void iValidateTextIsDisplayedInDropDownList(String text, String boxName) {
        Select select = new Select(driver.findElement(By.xpath(" //select[contains(@name,'" + boxName + "')]")));
        WebElement elm= select.getFirstSelectedOption();
        String selectedOption = elm.getText();
        Assert.assertEquals(selectedOption,text);
        System.out.println("Selected element: " + selectedOption+" is visible");
    }


    @Then("I validate that {string} element is visible on the page")
    public void iValidateThatElementIsVisibleOnThePage(String element) {
        WebElement validateElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertTrue(validateElement.isDisplayed());
        System.out.println("the text is :"+validateElement.getText());
    }
}

