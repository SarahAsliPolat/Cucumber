package stepDefs;

import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.config.SSLConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class VusalaStepDefs {
    WebDriver driver = Driver.getDriver();

    @Given("I logged in Vusala")
    public void iLoggedInVusala() throws Exception {
        PageObjectMgr.setCurrentPage("VusalaPage");

        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loadLogin");
        WebElement emailTexBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "emailSection");
        WebElement passwordTextBox = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "loginButton");
        WebElement newHire = (WebElement) WebElementMgr.getWebElement(PageObjectMgr.getCurrentPage(), "newHireButton");


        loadLogin.click();
        Thread.sleep(500);
        emailTexBox.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(500);
        passwordTextBox.sendKeys("admin123test");
        Thread.sleep(500);
        loginButton.click();

        WebElement wait = new WebDriverWait(Driver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(newHire));
        ScenarioManager.getScenario().write("I logged in");

    }

    @When("I click on {string} as Vusala")
    public void iClickOnAsVusala(String element) {
        WebElement ClickElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);

        ClickElement.click();

    }

    @And("I validate {string} message is displayed")
    public void iValidateMessageIsDisplayed(String message) throws Exception {

        String locator = "//*[contains(text(),'" + message + "')]";

        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.assertEquals(actual, message, "are not equal");
    }

    @Then("I enter {string} in the {string} as Vusala")
    public void iEnterInThe(String text, String element) {

        WebElement enterText = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        enterText.sendKeys(text);
    }

    @Then("I select {string} from {string} dropDownList")
    public void iSelectFromDropDown(String option, String element) {
        WebElement dropDown = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Select select = new Select(dropDown);
        select.selectByVisibleText(option);
    }

    @And("I scroll and click to {string} as Vusala")
    public void iScrollToAsVusala(String element) {
        WebElement scrollElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Actions built = new Actions(driver);
        built.moveToElement(scrollElement).click().build().perform();

    }


    @Then("I validate {string} Pop-Up page displayed")
    public void iValidatePopUpPageDisplayed(String element) throws Exception {
        WebElement validateElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertTrue(validateElement.isDisplayed());
    }

    @And("I validate {string} toaster message is displayed")
    public void iValidateToasterMessageIsDisplayed(String element) {

        WebElement validateToaster = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertFalse(validateToaster.getText().isEmpty());
    }


    @Then("I validate {string} text is displayed in {string} dropDown list")
    public void iValidateTextIsDisplayedInDropDownList(String text, String boxName) {
        Select select = new Select(driver.findElement(By.xpath(" //select[contains(@name,'" + boxName + "')]")));
        WebElement elm= select.getFirstSelectedOption();
        String selectedOption = elm.getText();
        Assert.assertEquals(selectedOption,text);
        System.out.println("Selected element: " + selectedOption+" is visible");
    }


    @Then("I validate that {string} element is visible on the page")
    public void iValidateThatElementIsVisibleOnThePage(String element) {
        WebElement validateElement = (WebElement) WebElementMgr.
                getWebElement(PageObjectMgr.getCurrentPage(), element);
        Assert.assertTrue(validateElement.isDisplayed());
        System.out.println("the text is :"+validateElement.getText());
    }

    @When("I print staff info with staff ID")
    public void iPrintStaffInfoWithStaffID() {
        String url = ConfigFileReader.getPropertyValue("getStaffInfo");
        Response response = null;
        RequestSpecification request = given();

        request=request.pathParams( "staff_id",67986);
        response = request.get(url);
        response.then().assertThat().statusCode(200);
        System.out.println(response.asString());

        String expected_staffId="6535992";
        String expected_location="High School";
        String expected_room="786";
        String actual_staffId=response.jsonPath().get("staff_id").toString();
        String actual_location=response.jsonPath().get("location").toString();
        String actual_room=response.jsonPath().get("room").toString();
        Assert.assertEquals(actual_staffId,expected_staffId,"staff id doesn't match");
        Assert.assertEquals(actual_location,expected_location,"location doesn't match");
        Assert.assertEquals(actual_room,expected_room,"room doesn't match");

    }

    @When("I create a new user")
    public void iCreateANewUser() {
        String url = "https://reqres.in/api/users";
        RequestSpecification request = given();
        Response response = null;
        JSONObject body123 = new JSONObject();
        body123.put("name", "ali");
        body123.put("job", "isci");
        request.header("Content-Type","application/json");
        request.body(body123.toJSONString());
        response = request.request(Method.POST,url);
        response.prettyPrint();
        response.getBody().asString();
        //status code validation
        int statusCode =response.getStatusCode();
        response.then().assertThat().statusCode(201);
        System.out.println("Status Code "+statusCode);
        String actualName=response.jsonPath().get("name").toString();
        String expectedName=body123.get("name").toString();
        Assert.assertEquals(actualName,expectedName);
        String actualJob=response.jsonPath().get("job").toString();
        String expectedJob=body123.get("job").toString();
        Assert.assertEquals(actualJob,expectedJob," expected job is not correct " );
        System.out.println("actualJob = "+actualJob + "\nactualName= "+actualName);
        System.out.println("expectedJob = "+expectedJob + "\nexpectedName= "+expectedName);
    }

    @When("I put new information")
    public void iPutNewInformation() {
        String url = "https://reqres.in/api/users/2";
        Response response = null;
        RequestSpecification request = given();
        JSONObject body123 = new JSONObject();
        body123.put("name", "John");
        body123.put("job", "Tester");
        request.header("Content-Type","application/json");
        request.body(body123.toJSONString());
        response = request.request(Method.PUT,url);
        response.prettyPrint();
        response.getBody().asString();
        //status code validation
        int statusCode =response.getStatusCode();
        response.then().assertThat().statusCode(200);
        System.out.println("Status Code "+statusCode);
        String actualName=response.jsonPath().get("name").toString();
        String expectedName=body123.get("name").toString();
        Assert.assertEquals(actualName,expectedName);
        String actualJob=response.jsonPath().get("job").toString();
        String expectedJob=body123.get("job").toString();
        Assert.assertEquals(actualJob,expectedJob," expected job is not correct " );
        System.out.println("actualJob = "+actualJob + "\nactualName= "+actualName);
        System.out.println("expectedJob = "+expectedJob + "\nexpectedName= "+expectedName);

    }

    @When("Delete the user")
    public void deleteTheUser() {
        String url = "https://reqres.in/api/users/2";
        Response response = null;
        RequestSpecification request = given();
        response = request.request(Method.DELETE,url);
        System.out.println(response);
        response.then().assertThat().statusCode(204);

    }
}

