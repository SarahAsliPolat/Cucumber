package stepDefs;


import Utilities.Driver;
import Utilities.PageObjectMgr;
import Utilities.ScenarioManager;
import Utilities.WebElementMgr;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static io.restassured.RestAssured.given;



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

//
//    @When("I click on {string} as Gulshat")
//    public void iClickOnAsGulshat(String element) {
//
//        WebElement clickElement = new WebDriverWait(Driver.getDriver(),
//                6).until(ExpectedConditions.visibilityOf(GulshatPage.newHireButton));
//    }

    @When("I click on {string} as Gulshat")
    public void clickButton(String element) {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
        WebElement wait = new WebDriverWait(Driver.getDriver(), 3).until(ExpectedConditions.elementToBeClickable(clickElement));
        wait.click();

    }

    //RT-4
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

    //RT-13
    @Then("I validate position filter is working")
    public void iValidatePositionFilterIsWorking() throws InterruptedException {
        String expected = "";
        String actual = "";
        List<WebElement> positions = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "positions");
        List<WebElement> staffMembers = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "staffMembers");
        WebElement position = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "position");
        for (int i = 1; i < positions.size(); i++) {
            positions.get(i).click();
            expected = positions.get(i).getText();

            for (int j = 2; j < staffMembers.size(); j++) {
                staffMembers.get(j).click();
                Thread.sleep(1000);
                actual = position.getText();
                System.out.println(expected + " as expected  " + actual + "   Actual");
                Assert.assertEquals("position does not match with positions filter", expected, actual);
            }

        }

    }

    //RT-20
    @Then("I validate the details below are present on the applicant information page")
    public void iValidateTheDetailsBelowArePresentOnTheApplicantInformationPage(List<String> expectedList) {
        int i = 0;

        try {
            for (i = 0; i < expectedList.size(); i++) {
                WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + expectedList.get(i) + "')]"));
                System.out.println(element.getText());
            }
        } catch (Exception e) {
            Assert.fail(expectedList.get(i) + " is not present on the applicant information page");
        }
    }

    //RT-25
    @And("I enter {string} in the {string} as Gulshat")
    public void iEnterInTheAsGulshat(String text, String textBox) {
        WebElement enterText = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), textBox);
        enterText.click();
        enterText.sendKeys(text);
    }

    @When("I select {string} from {string} drop-down")
    public void iSelectFromDropDown(String option, String element) {
        WebElement dropDown = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Select select = new Select(dropDown);
        select.selectByVisibleText(option);

    }

    @And("I scroll down and click to {string} button as Gulshat")
    public void iScrollDownAndClickToButtonAsGulshat(String element) {
        WebElement scrollElement = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), element);
        Actions built = new Actions(driver);
        built.moveToElement(scrollElement).click().build().perform();
    }

    @And("I enter {string} in the {string}")
    public void iEnterInThe(String sendText, String element) {
        WebElement enterName = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        enterName.sendKeys(sendText);
    }

    @Then("I validate the details below are present on the new position  page")
    public void iValidateTheDetailsBelowArePresentOnTheNewPositionPage(List<String> expectedList) {
        int i = 0;

        try {
            for (i = 0; i < expectedList.size(); i++) {
                WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + expectedList.get(i) + "')]"));
                System.out.println(element.getText());
            }
        } catch (Exception e) {
            Assert.fail(expectedList.get(i) + " is not present on the new position page");
        }
    }

    //RT-28
    @Then("I validate that the list below is present on the {string}")
    public void iValidateThatTheBelowIsPresentOnTheDropdown(String dropDown, List<String> expectedList) throws Exception {
        List<WebElement> dropDownList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), dropDown);
        for (int i = 0; i < expectedList.size(); i++) {
            dropDownList.get(i).getText().equals(expectedList.get(i));
            if (!dropDownList.get(i).getText().equals(expectedList.get(i))) {
                throw new Exception(" Fail; \n Expected: " + expectedList.get(i) + " \n Found : " + dropDownList.get(i).getText());
            }
        }
    }

    // API
    @When("I create a user in post api")
    public void iCreateAUserInPostApi() {
        String url = "https://reqres.in/api/users";
        Response response = null;
        RequestSpecification request = given();
        JSONObject body123 = new JSONObject();
        body123.put("name", "ali");
        body123.put("job", "isci");
        request.header("Content-Type", "application/json");
        request.body(body123.toJSONString());
        response = request.request(Method.POST, url);
        response.prettyPrint();
        response.getBody().asString();

        //status code validation
        int statusCode = response.getStatusCode();
        response.then().assertThat().statusCode(201);
        System.out.println("Status Code " + statusCode);

        String actualName = response.jsonPath().get("name").toString();
        String expectedName = body123.get("name").toString();
        Assert.assertEquals("expected name is not correct ", expectedName, actualName);

        String actualJob = response.jsonPath().get("job").toString();
        String expectedJob = body123.get("job").toString();
        Assert.assertEquals("expected job is not correct ", expectedJob, actualJob);

        System.out.println("actualJob = " + actualJob + "\nactualName= " + actualName);
        System.out.println("expectedJob = " + expectedJob + "\nexpectedName= " + expectedName);
    }

    @When("I delete a user")
    public void iDeleteAUser() {
        String url = "https://reqres.in/api/users/2";
        Response response = null;
        RequestSpecification request = given();
        response = request.request(Method.DELETE, url);
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
    }

    //Gulshat_001
    @Then("I validate {string} Applicants are displayed")
    public void iValidateApplicantsAreDisplayed(String expectedName) throws Exception {
        List<WebElement> webElementList = (List<WebElement>) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "locationColumn");
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
            if (element.getText().equals(expectedName)) {
            } else {
                throw new Exception(" Fail; \n Expected: " + expectedName + " \n Found : " + element.getText());
            }
        }
    }
}










