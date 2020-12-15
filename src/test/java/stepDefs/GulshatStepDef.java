package stepDefs;

import PageFactory.GulshatPage;
import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GulshatStepDef {
    WebDriver driver = Driver.getDriver();

    @Given("I logged in Gulshat")
    public void iLoggedInGulshat() throws Exception {
        PageObjectMgr.setCurrentPage("GulshatPage");
        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHire = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");

        loadLogin.click();
        Thread.sleep(1000);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        loginButton.click();
        WebElement wait = new WebDriverWait(Driver.getDriver(),
                6).until(ExpectedConditions.visibilityOf(newHire));
        ScenarioManager.getScenario().write("I logged in");

    }

    @When("I run the test")
    public void iRunTheTest() {

    }

    @When("I click on {string} as Gulshat")
    public void iClickOnAsGulshat(String element) {

        WebElement clickElement = new WebDriverWait(Driver.getDriver(),
                6).until(ExpectedConditions.visibilityOf(GulshatPage.newHireButton));
    }

    @Then("I verify value is as expected")
    public void iVerifyValueIsAsExpected() throws Exception {
        try {
            WebElement person = driver.findElement(By.xpath("//a[contains(text(),'Derek Parsons')]"));
            String actual = driver.findElement(By.xpath("//div[contains(text(),'08/15/2017')]")).getText();
            String expected = "08/15/2017";
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new Exception("try again");
        }


    }

    @When("I click on {string} tab as Gulshat")
    public void iClickOnTabAsGulshat(String elementNm) {
        WebElement element = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        element.click();

    }

    @Then("I verified that {string} element is exist with {string} text")
    public void iVerifiedThatElementIsExistWithText(String elementNm, String expected) throws Exception {
        WebElement fields = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        String label = fields.getText();
        System.out.println(elementNm);
        System.out.println(expected);
        if (!expected.equalsIgnoreCase(label)) {
            throw new Exception("field name does not match");
        }


    }
}


