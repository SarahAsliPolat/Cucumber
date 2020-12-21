package stepDefs;

import PageFactory.IsmailPage;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ismailStepdef {

    @Given("I am on the IsmailPage" )
    public void iAmOnThe(String pageNm) throws Exception {
        PageObjectMgr.setCurrentPage(pageNm);
        ScenarioManager.getScenario().write("User is on " + pageNm + "IsmailPage");
    }



    @Then("I Validate the newHire text list has these below")
    public void iValidateTheNewHireTextListHasTheseBelow(List<String> expectedList) throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"newHire" );

        String expectedValue;
        String actualValue;

        for (int i = 0; i < expectedList.size() ; i++) {
            expectedValue = expectedList.get(i);

            actualValue = actualList.get(i).getText();

            System.out.println(expectedValue);
            System.out.println(actualValue);
            if (!actualValue.equals(expectedValue)) {
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }
    }
}
