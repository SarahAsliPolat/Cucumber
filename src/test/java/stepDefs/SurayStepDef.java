package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SurayStepDef {
    @Given("I logged in Suray")
    public void iloggedInSurayPage() throws Exception{
        PageObjectMgr.setCurrentPage ("LoginPage");
        WebElement loadLogin= (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "loadLogin");
        WebElement emailTextBox=(WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "emailSection");
        WebElement passwordTextBox=(WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "passwordSection");
        WebElement loginButton=(WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "loginButton");
        WebElement newHire=(WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "newHireButton");

        loadLogin.click();

        Thread.sleep(1000);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();
        WebElement wait=new WebDriverWait(Driver.getDriver(),5).
                until(ExpectedConditions.visibilityOf(newHire));



    }



    @Then("the user validates the basicTab in the right side of the page")
    public void the_user_validates_the_basicTab_in_the_right_side_of_the_page(List<String> expectedList) throws Exception {
        PageObjectMgr.setCurrentPage ("SurayPage");
            List <WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"tabList" );

            String expectedValue;
            String actualValue;

        for (int i = 0; i < actualList.size(); i++) {
            actualValue=actualList.get(i).getText();
            System.out.println("actualValue: "+actualValue);
            Assert.assertTrue(expectedList.contains(actualValue));
        }
    }
}
