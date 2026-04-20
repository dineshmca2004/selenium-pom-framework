package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }

    protected WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    protected void click(By locator){
        waitForClickable(locator).click();
    }

    protected String getText(By locator){
        return waitForVisible(locator).getText();
    }

    protected void type(By locator, String value){
        WebElement webElement = waitForVisible(locator);
        webElement.clear();
        webElement.sendKeys(value);
    }
    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }
}
