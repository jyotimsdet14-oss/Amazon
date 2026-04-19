package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class ElementUtils {

    public static void click(WebDriver driver, WebElement element) 
    {
        waitForElement(driver, element);
        element.click();
        Log.info("Clicked element");
    }

    public static void sendKeys(WebDriver driver, WebElement element, String text) 
    {
        waitForElement(driver, element);
        element.clear();
        element.sendKeys(text);
        Log.info("Entered text: " + text);
    }

    public static void waitForElement(WebDriver driver, WebElement element)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void jsClick(WebDriver driver, WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static String getText(WebDriver driver, WebElement element)
    {
        waitForElement(driver, element);
        return element.getText();
    }
    public static void switchToNewWindow(WebDriver driver) {

        String parent = driver.getWindowHandle();

        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
                break;
            }
        }

        Log.info("Switched to new window");
    }
}