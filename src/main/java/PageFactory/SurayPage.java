package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SurayPage {


//    @FindBy(how = How.XPATH, using = "//a[@data-toggle='tab'][1]")
//    public static WebElement basicTab;
//
//
//    @FindBy(how = How.XPATH, using = "//a[@data-toggle='tab'][2]")
//    public static WebElement detailsTab;
//
//    @FindBy(how = How.XPATH, using = "//a[@data-toggle='tab'][3]")
//    public static WebElement attendanceTab;
//
//    @FindBy(how = How.XPATH, using = "//a[@data-toggle='tab'][4]")
//    public static WebElement filesTab;

    @FindBy(how = How.XPATH,using = "//a[@data-toggle='tab']")
    public List<WebElement> tabList;
}
