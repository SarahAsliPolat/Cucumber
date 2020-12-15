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

}
