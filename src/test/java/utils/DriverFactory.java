package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser){

        switch(browser.toLowerCase()) {
            case "chrome":
                webDriver.set(new ChromeDriver());
                break;
            case "firefox":
                webDriver.set(new FirefoxDriver());
                break;
            default:
                throw new RuntimeException("Unsupported browser::" + browser);
        }

        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
