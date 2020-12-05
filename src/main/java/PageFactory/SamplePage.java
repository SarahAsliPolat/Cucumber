package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SamplePage {

    @FindBy(how = How.XPATH, using = "//div[@id='v-pills-tab']/select[1]")
    public static WebElement JobFilter;

    @FindBy(how = How.XPATH, using = "//div[@id='v-pills-tab']/select[1]/option")
    public static List<WebElement> jobFilterList;

}