package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class McengizPage {
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

    //    Applicants and Position Types page
    @FindBy(how = How.CSS, using = "[href='https://hr-testing.buffsci.org/applicants'] p")
    public static WebElement Applicants;

    @FindBy(how = How.CSS, using = "[href='https://hr-testing.buffsci.org/staff-positions'] p")
    public static WebElement Positions;

    @FindBy(how = How.CSS, using = "[name='location_id']")
    public static WebElement LocationFilter;

    @FindBy(how = How.CSS, using = "[name='position_type_id']")
    public static WebElement PositionFilter;

    @FindBy(how = How.CSS, using = "[name='status']")
    public static WebElement StatusFilter;

    @FindBy(how = How.CSS, using = ".sorting_1")
    public static List<WebElement> LocationColumn;

    @FindBy(how = How.XPATH, using = "//tr[@role='row']/td[2]")
    public static List<WebElement> PositionColumn;

    @FindBy(how = How.XPATH, using = "//tr[@role='row']/td[6]")
    public static List<WebElement> StatusColumn;

    @FindBy(how = How.XPATH, using = "//li[@class='paginate_button page-item next']")
    public static WebElement Next;

    @FindBy(how = How.XPATH, using = "//li[@class='paginate_button page-item previous']")
    public static WebElement Previous;

    @FindBy(how = How.CSS, using = ".dataTables_empty")
    public static WebElement noData;





}
