package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class IsmailPage {


    @FindBy(how = How.XPATH, using = "//i[@class='nav-icon material-icons']//parent::a")
    public static WebElement StaffButton;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Staff List')]")
    public static WebElement StaffButmenu;


    @FindBy(how = How.XPATH, using = "//li[@class='nav-item']")
    public static WebElement the4Buttons;



    @FindBy(how = How.XPATH, using = "//a[text()='Basic']")
    public static WebElement Basic;
    @FindBy(how = How.XPATH, using = "//a[text()='Details']")
    public static WebElement Details;
    @FindBy(how = How.XPATH, using = "//a[text()='Attendance']")
    public static WebElement Attendance;
    @FindBy(how = How.XPATH, using = "//a[text()='Files']")
    public static WebElement Files;


    //Ismail003_Validate all the labels on the Basic Page.

     @FindBy(how = How.XPATH, using = "//div[contains(@class,'form-group col-sm-6')]//label")
     public static List<WebElement> BasicLable;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'form-group col-sm-12')]//*[text() ='Home Address:']")
    public static WebElement BasicHomeAdress;
    @FindBy(how = How.XPATH, using = "//button[text() ='Edit Basic Info']")
    public static WebElement EditBasicInfoButton;





}
