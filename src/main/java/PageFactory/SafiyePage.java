package PageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SafiyePage {

    @FindBy(xpath= "//button[2]")
    public static WebElement terminationButton;

    @FindBy(xpath= "//input[@placeholder='mm/dd/yyyy']")
    public static WebElement terminationDate;

    @FindBy(xpath= "//label[text()='Reason:']/../select")
    public static WebElement reasonDropdown;

    @FindBy(xpath= "//button[text()='Save']")
    public static WebElement saveButton;

    @FindBy(xpath= "//button[text()='Cancel']")
    public static WebElement cancelButton;

}
