package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome"))
        {
            driver.set(new ChromeDriver());
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}