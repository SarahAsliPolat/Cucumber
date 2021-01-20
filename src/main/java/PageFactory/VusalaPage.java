package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VusalaPage {

    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;

    @FindBy(how=How.ID, using="email")
    public static WebElement emailSection;

    @FindBy(how=How.ID, using="password")
    public static WebElement passwordSection;

    @FindBy(how=How.CSS, using="button[type='submit']")
    public static WebElement loginButton;



    @FindBy(how = How.XPATH, using = "//button[text()='New Hire']")
    public static WebElement newHireButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")
    public static WebElement saveButton;



    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Positions')]")
    public static WebElement Positions;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add New')]")
    public static WebElement AddNew;

    @FindBy(how = How.XPATH, using =
      "//label[contains(text(),'Title')]//following::input")
    public static WebElement Title;

    @FindBy(how = How.XPATH,using = "//select[@name='position_type_id' and @class='form-control']")
    public  static WebElement PositionType;

    @FindBy(how = How.XPATH,using = "//select[@name='location_id' and @class='form-control']")
    public  static WebElement Location;

    @FindBy(how = How.XPATH,using = "//select[@name='reports_to_id' and @class='form-control']")
    public  static WebElement ReportsTo;

    @FindBy(xpath = "//button[text()='Save']")
    public static WebElement Save;

    @FindBy(how = How.XPATH, using = "//a[@data-target='#modalDelete']")
    public static WebElement deleteButton;

    @FindBy(xpath = "//button[text()='OK']")
    public static WebElement ok;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Confirm to Delete')]")
    public static WebElement ConfirmToDelete;

    @FindBy(className = "toast-message")
    public static WebElement toasterValidation;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Search')]//following::input")
    public static WebElement Search;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'No matching records found')]")
    public static WebElement No_matching_records_found;



    @FindBy(how = How.XPATH,using = "//select[@name='location_id' and @class='filter ml-4']")
    public  static WebElement SelectLocation;

    @FindBy(how = How.XPATH,using = "//select[@name='position_type_id' and @class='filter ml-4']")
    public  static WebElement SelectPosition;

    @FindBy(how = How.XPATH,using = "//select[@name='status' and @class='filter ml-4']")
    public  static WebElement SelectStatus;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Clear Filters')]")
   public static WebElement ClearFilters;



    @FindBy(how = How.XPATH, using = "//a[@href='https://hr-testing.buffsci.org/applicants']")
    public static WebElement Applicants;

    @FindBy(how = How.XPATH, using = "//h5[contains(text(),'Applicants')]")
    public static WebElement ApplicantsText;

    @FindBy(how = How.XPATH, using = "//span[@class='brand-text font-weight-light']")
    public static WebElement BuffsciTitle;

    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-users mr-1']//parent::h3")
    public static WebElement StaffList;

}
