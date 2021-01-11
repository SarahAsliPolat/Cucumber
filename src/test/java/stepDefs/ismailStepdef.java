package stepDefs;

import PageFactory.IsmailPage;
import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ismailStepdef {

    @Given("I am on the {string} as ismail")
    public void i_am_on_the_as_ismail(String pageNm) throws Exception {
        PageObjectMgr.setCurrentPage(pageNm);
        ScenarioManager.getScenario().write("User is on " + pageNm + " page");
    }

    @When("I wait for {string} to be {string} as ismail")
    public void i_wait_for_to_be_as_ismail(String elementNm, String state) {
        WebElement waitElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), 6).
                pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        if (state.equals("visible"))
            wait.until(ExpectedConditions.visibilityOf(waitElement));
        else
            wait.until(ExpectedConditions.elementToBeClickable(waitElement));
    }

    @Then("I click on {string} as ismail")
    public void i_click_on_as_ismail(String elementNm) throws Exception {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);

        try {
            clickElement.click();
            ScenarioManager.getScenario().write("Clicked on " + elementNm);
        } catch (Exception e) {
            throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }



    @Then("I enter {string} in {string} as ismail")
    public void i_enter_in_as_ismail(String value, String elementNm) throws Exception {
        WebElement editElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), elementNm);
        try {
            editElement.click();
        } catch (Exception e) {
            editElement.sendKeys(Keys.RETURN);
        }
        try {
            editElement.clear();
            editElement.sendKeys(value);
            ScenarioManager.getScenario().write("Entered value " + value + " in " + elementNm);
        } catch (Exception e) {
            throw new Exception("Unable to enter value " + value + " in " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }

    @Then("I wait for {string} milliseconds as ismail")
    public void witingmement(String waitTime) throws Exception {
        Thread.sleep(Long.parseLong(waitTime));
        ScenarioManager.getScenario().write("Waited for " + waitTime + " milliseconds");
    }
    @Then("I Validate the newhire list has these below as ismail")
    public void i_Validate_the_jobFilterList_drop_down_list_has_these_below_as_ismail(List<String> expectedList ) throws Exception{
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(),"Texts" );

        String expectedValue;
        String actualValue;

        for (int i = 0; i < expectedList.size() ; i++) {
            expectedValue = expectedList.get(i);

            actualValue = actualList.get(i).getText();
            System.out.println("expected values: "+expectedValue+" actual values: "+actualValue);
            if (!actualValue.equals(expectedValue)) {
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }

    @Then("I Validate the dropDown job list down list has these below as ismail")
    public void iValidateTheDropDownJobListDownListHasTheseBelowAsIsmail(List<String> expectedList )  throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "jobDropDownText");

        String expectedValue;
        String actualValue;

        for (int i = 0; i < expectedList.size(); i++) {
            expectedValue = expectedList.get(i);

            actualValue = actualList.get(i).getText();
            System.out.println("expected values: "+i + expectedValue + " actual values: "+i + actualValue);
            if(actualValue.equals("")){
                continue;
            }
            else if (!actualValue.equals(expectedValue)) {
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }

        }
    }




    @Then("make sure the selectposition function  is working properly")
    public void makeSureTheSelectpositionFunctionIsWorkingProperly() throws Exception{
        List<WebElement>positionList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "p1");
        List<WebElement> identicalValue = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "p2");

        String pos=null;
        String ido=null;
        Thread.sleep(400);
        for (int i = 1; i <positionList.size() ; i++) {

        positionList.get(i).click();
            pos=positionList.get(i).getText();
            Thread.sleep(400);
            System.out.println(pos);
            for (int j = 0; j <identicalValue.size() ; j++) {

                Thread.sleep(400);
           ido=identicalValue.get(j).getText();
                System.out.println(ido);
           if (!ido.equals(null)){
               if (!ido.equals(pos)) {
                   throw new Exception(" Fail; \n Expected: " + pos + " \n Found : " + ido);
               }

           }
                else if (ido.equals(null)){
                    pos=null;
                    if (!ido.equals(pos)) {
                        throw new Exception(" Fail; \n Expected: " + pos + " \n Found : " + ido);
                    }

                }
       }

   }

    }



    @Then("i validate all the text on the position page")
    public void iValidateAllTheTextOnThePositionPage(List<String >ExpectedList) throws Exception{
       List< WebElement> actualElement = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "ptextPositions");
       String Exp;
       String Actu;

        for (int i = 0; i <ExpectedList.size() ; i++) {
           Exp= ExpectedList.get(i);
           Actu=actualElement.get(i).getText();
            System.out.println(("  Expected :"+Exp+" \n Found : "+Actu));
           if (!Exp.equalsIgnoreCase(Actu)){
               throw new Exception("Fail; \n Expected :"+Exp+" \n Found : "+Actu);
           }


        }

    }

    @Then("i validate the {string} page pups up")
    public void iValidateThePagePupsUp(String expected)throws Exception {
        WebElement actualElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newPostionpage");
        if (!actualElement.getText().equalsIgnoreCase(expected)){
            throw new Exception("Fail; \n Expected :"+expected+" \n Found : "+actualElement.getText());
        }


    }
}