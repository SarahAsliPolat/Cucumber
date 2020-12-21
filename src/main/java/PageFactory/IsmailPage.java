package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class IsmailPage {
    @FindBy( xpath = "//*[@id='newHireForm']/div/div/label")
    public static List<WebElement> newHire;
}
