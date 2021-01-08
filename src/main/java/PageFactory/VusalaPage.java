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

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Showing 0 to 0 of 0 entries (filtered from 202 total entries)')]")
    public static WebElement IsEmpty;


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Clear Filters')]")
   public static WebElement ClearFilters;
}
