package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MCengizStepdefs {

    @Given("I logged in MCengiz")
    public void iLoggedInMCengiz() throws Exception {
        PageObjectMgr.setCurrentPage("McengizPage");
        WebElement loadLogin=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTextBox=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHire=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");

        loadLogin.click();
        Thread.sleep(1000);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();
        WebElement wait = new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(newHire));
        ScenarioManager.getScenario().write("I logged in");


    }

    @When("I run the test")
    public void iRunTheTest() {
    }

    @When("I click on {string} as MCengiz")
    public void iClickOnAsMCengiz(String element) {
        WebElement ClickElement=  (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);

        ClickElement.click();
    }
}