package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbdulStepDefs {
	
	@Given("I logged in as Abdul")
	public void iLoggedInAbdul() throws Exception {
		PageObjectMgr.setCurrentPage("LoginPage");
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
		Thread.sleep(1000);
		loginButton.click();
		WebElement wait = new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(newHire));
		ScenarioManager.getScenario().write("I logged in");
		PageObjectMgr.setCurrentPage("AbdulPage");
		Assert.assertEquals("Cannot login!",
				"https://hr-testing.buffsci.org/home",
				Driver.getDriver().getCurrentUrl());
	}
	
	@When("I click on {string} as Abdul")
	public void iClickOnAsAbdul(String element) {
		WebElement ClickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
		ClickElement.click();
	}
	
	@Then("I should see {string} as Abdul")
	public void iSeeElementAsAbdul(String element) {
		WebElement el = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
		Assert.assertTrue(element + " not visible!", el.isDisplayed());
	}
	
	@And("I should see {string} and it should show {string}")
	public void iShouldSeeAndItShouldShow(String element, String text) {
		WebElement el = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
		Assert.assertEquals(element + " is not showing " + text,
				text,
				el.getAttribute("value"));
	}
}
