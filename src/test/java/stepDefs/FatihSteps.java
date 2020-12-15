package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class FatihSteps {
    @Given("I logged in fatih")
    public void i_logged_in() throws Exception {
        PageObjectMgr.setCurrentPage("LoginPage");

        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"loadLogin");
        WebElement emailTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"loginButton");
        WebElement newHireButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"newHireButton");
        loadLogin.click();
        Thread.sleep(1500);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        passwordTextBox.sendKeys("admin123test");
        loginButton.click();
        Thread.sleep(4000);
        WebElement wait = new WebDriverWait(Driver.getDriver(), 6).until(ExpectedConditions.visibilityOf(newHireButton));

    }

    @When("i run the test")
    public void iRunTheTest() {
    }

    @When("i click on {string} button")
    public void iClickOnButton(String arg0) {

    }

    @Then("I wait for {string} miliseconds")
    public void iWaitForMiliseconds(String arg0) {

    }
}
