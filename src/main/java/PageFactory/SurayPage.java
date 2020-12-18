package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SurayPage {


    @FindBy(how = How.XPATH,using = "//a[@data-toggle='tab']")
    public List<WebElement> tabList;
}
