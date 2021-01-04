package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class IsmailPage {
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





    @FindBy( xpath = "//*[@id='newHireForm']/div/div/label")
    public static List<WebElement> Texts;


    @FindBy( xpath = "//select[1]")
    public static WebElement jobTap;


    @FindBy( xpath = "//select[1]/option")
    public static List<WebElement> jobDropDownText;


    @FindBy( xpath = "//i[contains(text(),'record_voice_over')]")
    public static WebElement applicationsTap;

    @FindBy( xpath = "//h5")
    public static WebElement applicationsText;

    //new task
    @FindBy( xpath = "//*[@id='root']/section/div/div/div/form/div/select[2]")
    public static WebElement selectPositionFiled;

    @FindBy( xpath = "//select[@class=\"filter ml-4\"][2]/option")
    public static List<WebElement> p1;

    @FindBy( xpath = "//tbody/tr/td[2]")
    public static List<WebElement> p2;




}
