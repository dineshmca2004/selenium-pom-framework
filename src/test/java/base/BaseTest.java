package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected ConfigReader configReader;

    @BeforeMethod
    public void setup(){
        configReader = new ConfigReader();
        String browser = configReader.getBrowser();
        System.out.println("Browser read from property file " + browser);
        DriverFactory.initializeDriver(browser);
        // launch base url
        String baseUrl = configReader.getBaseUrl();
        System.out.println("Base URL read from property file " + baseUrl);
        DriverFactory.getDriver().get(baseUrl);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
