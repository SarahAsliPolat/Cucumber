package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class SurayStepDef {
    @Given("I logged in Suray")
    public void iloggedInSurayPage() throws Exception {
        PageObjectMgr.setCurrentPage("LoginPage");
        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "loadLogin");
        WebElement emailTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "loginButton");
        WebElement newHire = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),
                "newHireButton");

        loadLogin.click();

        Thread.sleep(1000);
        emailTextBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();
        WebElement wait = new WebDriverWait(Driver.getDriver(), 5).
                until(ExpectedConditions.visibilityOf(newHire));


    }

    @Given("I set my page {string}")
    public void i_set_my_page(String page) throws Exception {
        PageObjectMgr.setCurrentPage(page);

    }


    @Then("the user validates that staff info tabs are on the staff page")
    public void the_user_validates_that_staff_info_tabs_are_on_the_staff_page(List <String> expectedList) throws Exception {

        List <WebElement> actualList = (List <WebElement>) WebElementMgr.getWebElement(PageObjectMgr.
                getCurrentPage(), "tabList");

        String actualValue;
        if (actualList.size() == expectedList.size()) {
            for (int i = 0; i < actualList.size(); i++) {
                actualValue = actualList.get(i).getText();
                System.out.println("actualValue: " + actualValue);
                Assert.assertTrue(expectedList.contains(actualValue));
            }

        } else {
            Assert.fail("list size are not same");
        }
    }


    @When("the user clicks to {string}")
    public void the_user_clicks_to(String elementName) {
        WebElement element = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.
                getCurrentPage(), elementName);
        element.click();
    }

    @Then("the user should see the  following columns")
    public void the_user_should_see_the_following_columns(List <String> expectedList) throws Exception {

        List <WebElement> columnNames = (List <WebElement>) WebElementMgr.getWebElement(PageObjectMgr.
                getCurrentPage(), "columns");

        System.out.println("column size: " + columnNames.size());
        for (int i = 0; i < columnNames.size() - 1; i++) {
            System.out.println("column name: " + columnNames.get(i).getText());
            Assert.assertTrue(expectedList.contains(columnNames.get(i).getText()));
        }
    }
    //RT-22


    @Then("the user validates pages corresponding with the navigation bar")
    public void the_user_clicks_to_pages_on_the_navigation_bar() {
        List <Integer> navList = Arrays.asList(1, 2, 3, 4, 5, 6);
        WebElement navText = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.
                getCurrentPage(), "navText");
        for (int i = 0; i < navList.size(); i++) {
            WebElement navigation = Driver.getDriver().findElement(By.xpath("//a[@class='page-link' and contains(text(),'" + navList.get(i) + "')]"));
            navigation.click();
            int start = (navList.get(i)) * 10 - 9;
            System.out.println(navText.getText().substring(8, 10));
            if (i == 0) {
                Assert.assertEquals(Integer.valueOf(start), Integer.valueOf(navText.getText().substring(8, 9)));
            } else {
                Assert.assertEquals(Integer.valueOf(start), Integer.valueOf(navText.getText().substring(8, 10)));
            }

        }
    }
}
