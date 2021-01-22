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

    @FindBy(how = How.ID, using = "password")
    public static WebElement passwordSection;

    @FindBy(how = How.CSS, using = "button[type='submit']")
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
    public static WebElement JobBox;

    @FindBy(xpath = "//select[1]/option")
    public static List<WebElement> positions;

    @FindBy(css = "a.nav-link[href='#']")
    public static List<WebElement> staffMembers;

    @FindBy(xpath = "//*[text()='Position:']/../div")
    public static WebElement position;


    //RT-20
    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Applicants']")
    public static WebElement applicants;

    @FindBy(how = How.XPATH, using = "//div[@class='btn-group']")
    public static WebElement edit;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Applied At:')]")
    public static WebElement appliedAt;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Address:')]")
    public static WebElement address;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Email:')]")
    public static WebElement email;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Experience:')]")
    public static WebElement experience;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Certifications:')]")
    public static WebElement certification;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Resume / Documents:')]")
    public static WebElement resumeDocuments;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Recent Updates:')]")
    public static WebElement recentUpdates;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Updated At:')]")
    public static WebElement updatedAt;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Phone Number:')]")
    public static WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Notes:')]")
    public static WebElement notes;

    //RT-25
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Positions')]")
    public static WebElement positionsPage;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add New')]")
    public static WebElement addNew;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Title')]")
    public static WebElement titleText;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Title')]//following::input")
    public static WebElement titleBox;

    @FindBy(how = How.XPATH, using = "//textarea[@name='notes']")
    public static WebElement noteBox;

    //latest
    @FindBy(how = How.XPATH, using = "//select[@name='location_id' and @class='form-control']")
    public static WebElement locationDropDown;

    @FindBy(how = How.XPATH, using = "//select[@name='position_type_id' and @class='form-control']")
    public static WebElement positionDropDown;

    @FindBy(how = How.XPATH, using = "//select[@class='form-control select2-hidden-accessible']")
    public static WebElement assignedStaff;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='OK']")
    public static WebElement confirmOk;

    @FindBy(how = How.XPATH, using = "//select[@name='reports_to_id' and @class='form-control']")
    public static WebElement reportsToDropDown;

    @FindBy(how = How.XPATH, using = "//label[normalize-space()='Supervisor']//following::input[2]")
    public static WebElement Supervisor_No;

    @FindBy(how = How.XPATH, using = "//label[normalize-space()='Posted']//following::input[1]")
    public static WebElement posted_Yes;

    @FindBy(xpath = "//button[text()='Save']")
    public static WebElement save;

    @FindBy(className = "toast-message")
    public static WebElement staffPositionSaved;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Search')]//following::input")
    public static WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//form[@id='staff-positions-form']//button[@aria-label='Close']")
    public static WebElement closeButton;

    @FindBy(how = How.XPATH, using = "//a[@data-target='#modalDelete']")
    public static WebElement deleteButton;

    @FindBy(xpath = "//button[text()='OK']")
    public static WebElement ok;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Confirm to Delete')]")
    public static WebElement ConfirmToDelete;

    @FindBy(how = How.XPATH, using = "//h4[normalize-space()='Confirm']")
    public static WebElement confirm;

    //RT-28
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Termination')]")
    public static WebElement termination;

    @FindBy(how = How.XPATH, using = "//select[@class='form-control']")
    public static WebElement ReasonDropDown;

    @FindBy(how = How.XPATH, using = "//select[@class='form-control']//following::option")
    public static List<WebElement> ReasonDropDownList;


}
