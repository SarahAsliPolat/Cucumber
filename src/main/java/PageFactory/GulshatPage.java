package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GulshatPage {

    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;

    @FindBy(how = How.ID, using = "email")
    public static WebElement emailSection;

    @FindBy(how=How.ID, using="password")
    public static WebElement passwordSection;

    @FindBy(how=How.CSS, using="button[type='submit']")
    public static WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//button[text()='New Hire']")
    public static WebElement newHireButton;

//Details section
    @FindBy(xpath = "//a[contains(text(),'Details')]")
    public static WebElement details;

    @FindBy(xpath = "//label[normalize-space()='Original Hire Date:']")
    public static WebElement originalHireDate;

    @FindBy(xpath = "//label[contains(text(),'Contract Work Days:')]")
    public static WebElement contractWorkDays;

    @FindBy(xpath = "//label[contains(text(),'Employment Basis:')]")
    public static WebElement employmentBasis;

    @FindBy(xpath = "//label[contains(text(),'Education Level:')]")
    public static WebElement educationalLevel;

    @FindBy(xpath = "//label[contains(text(),'Annual Contract Work Months:')]")
    public static WebElement annualContractWorkMonth;

    @FindBy(xpath = "//label[contains(text(),'Previous Years of Teaching Experience:')]")
    public static WebElement previousYearsOfTeachingExperience;

    @FindBy(xpath = "//label[contains(text(),'Birth Date:')]")
    public static WebElement birthDate;

    @FindBy(xpath = "//label[contains(text(),'Gender:')]")
    public static WebElement gender;

    @FindBy(xpath = "//label[contains(text(),'Native Language:')]")
    public static WebElement nativeLanguage;

    @FindBy(xpath = "//label[contains(text(),'Secondary Language:')]")
    public static WebElement secondaryLanguage;

    @FindBy(xpath = "//label[contains(text(),'Place of Birth:')]")
    public static WebElement placeOfBirth;

    @FindBy(xpath = "//label[contains(text(),'Country of Origin:')]")
    public static WebElement countryOfOrigin;

    @FindBy(xpath = "//label[contains(text(),'Hispanic:')]")
    public static WebElement hispanic;

    @FindBy(xpath = "//label[contains(text(),'Race:')]")
    public static WebElement race;

    //RT-13
    @FindBy(xpath = "//select[1]")
    public  static WebElement JobBox;

    @FindBy( xpath = "//select[1]/option")
    public static List<WebElement> positions;

    @FindBy (css = "a.nav-link[href='#']")
    public  static List<WebElement> staffMembers;

    @FindBy(xpath = "//*[text()='Position:']/../div")//.form-control
    public  static WebElement position;


}
