package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EmrePage {

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

    @FindBy(how = How.XPATH, using = "//input[@class='form-control m-1']")
    public static WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//div[@class=\"card-body overflow-auto\"]/descendant::a[@class=\"nav-link\"]")
    public static List<WebElement> searchResult;





}
