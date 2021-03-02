package stepDefs;

import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class MCengizStepdefs {

    @Given("I logged in MCengiz")
    public void iLoggedInMCengiz() throws Exception {
        PageObjectMgr.setCurrentPage("McengizPage");
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


    }


    @Then("I validate that {string} filter is working as expected")
    public void iValidateThatFilterIsWorkingAsExpectedIn(String filter) throws Exception {
        HashMap<String, Integer> options = new HashMap<String, Integer>();
        String filterLocator = filter + "Filter";
        String columnLocator = filter + "Column";
        Boolean flag = false;
        List<WebElement> columnValues = null;
        WebElement Next = null;
        WebElement Previous = null;
        Next = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "Next");
        WebElement dropDown = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), filterLocator);


        Select select = new Select(dropDown);
        String selectedOption = "";

        // Add unique keys and values as number of appearances
        int count = 0;
        while (true) {
            columnValues = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), columnLocator);
            for (WebElement columnValue : columnValues) {
                String value = columnValue.getText();
                if (options.containsKey(value)) {
                    options.put(value, options.get(value) + 1);
                } else {
                    options.put(value, 1);
                }
            }
            // Click next until Next button is disabled. Then Break the loop
            try {
                Next.click();
            } catch (Exception e) {
                break;
            }
            count++;
        }
        //Select each option from the dropdown by index one by one
        for (int i = 0; i < select.getOptions().size(); i++) {
            select.selectByIndex(i);
            int totalDisplayed = 0;
            WebElement elm = select.getFirstSelectedOption();
            selectedOption = elm.getText();
            // If option is Not in the hashmap We should see no data
            if (!options.containsKey(selectedOption)) {
                try {
                    WebElement noData = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "noData");
                } catch (Exception e) {
                    //Flag is an indicator that test is failed. I will check the state of the flag and failed the test at the end but I want to check all dropdown list first.
                    flag = true;
                    ScenarioManager.getScenario().write(selectedOption + " filter is not working. Expected to see no data but some data present.");
                }
                // If option is in the hashmap column text should match with filter text
            } else {
                int k = 0;
                while (true) {

                    // when some filters selected, first page 2 is displayed. If it is the case, I click previous to go to first page
                    if (k == 0) {
                        try {
                            while (true) {
                                Previous = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "Previous");
                                Previous.click();
                            }
                        } catch (Exception ignored) {
                            Thread.sleep(1000);
                        }
                    }
                    //Update Next button and column values on each page
                    Next = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "Next");
                    columnValues = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), columnLocator);
                    //Compare filter text with column values text
                    for (WebElement columnValue : columnValues) {
                        String value = columnValue.getText();
                        if (!value.equals(selectedOption)) {
                            flag = true;
                            ScenarioManager.getScenario().write(selectedOption + ": filter is not working\nExpected:" + selectedOption + "\nFound: " + value);
                        }
                    }
                    //This counts the total number of values for each value. It will add columns if we have several pages
                    totalDisplayed = totalDisplayed + columnValues.size();

                    // Click next until Next button is disabled. Then Break the loop
                    try {
                        Next.click();
                    } catch (Exception e) {
                        break;
                    }
                    k++;

                }
                // Compare the number of values with the initial hashmap
                if (totalDisplayed != options.get(selectedOption)) {
                    flag = true;
                    ScenarioManager.getScenario().write(selectedOption + " filter is not working\nExpected:" + options.get(selectedOption) + "\nFound: " + totalDisplayed);
                }
            }

        }
        //Fail the test if anf filter not working
        if (flag) {
            throw new Exception("Some filters are not working");
        } else {
            ScenarioManager.getScenario().write(filter + ": Working properly");
        }
    }
}
