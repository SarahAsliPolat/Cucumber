package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SurayPage {


    @FindBy(how = How.XPATH,using = "//a[@data-toggle='tab']")
    public List<WebElement> tabList;


    @FindBy(how=How.XPATH,using = "//p[contains(text(),'Applicants')]")
    public static WebElement applicants;


    @FindBy(how = How.XPATH,using = "//th[contains(@class,'sorting')]")
    public static List<WebElement> columns;

    @FindBy(how = How.XPATH,using = "//div[@class='dataTables_info']")
    public static WebElement navText;
}

