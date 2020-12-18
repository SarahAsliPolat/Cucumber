package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AbdulPage {
    
    @FindBy(css = "button[class='btn btn-secondary']")
    WebElement editHomeButton;
    
    @FindBy(css = "div.form-group.col-sm-12:nth-child(1) > input")
    WebElement addressLine1;
    
    @FindBy(css = "div.form-group.col-sm-12:nth-child(2) > input")
    WebElement addressLine2;
    
    @FindBy(css = "div.form-group.col-sm-6:nth-child(3) > input")
    WebElement cityField;
    
    @FindBy(css = "input[disabled='disabled']")
    WebElement stateField;
    
    @FindBy(xpath = "//div[5]//input[1]")
    WebElement zipCodeField;
    
    @FindBy(xpath = "//div[6]//input[1]")
    WebElement phoneField;
    
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;
    
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;
}
