package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;


public class Driver {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver != null) {
            SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
            if (sessionid != null) {
                return driver;
            } else {
                createInstance(Constants.BROWSER_NAME);
            }

        } else {
            createInstance(Constants.BROWSER_NAME);
        }
        return driver;
    }

    public static void createInstance(String browserName) {
        DesiredCapabilities capability = new DesiredCapabilities();
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                chromeOptions.merge(capability);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                firefoxOptions.merge(capability);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "ie":
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                internetExplorerOptions.merge(capability);
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                WebDriverManager.edgedriver().setup();
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                ScenarioManager.getScenario().write("Browser name is not found");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to(Constants.URL);
    }

}
