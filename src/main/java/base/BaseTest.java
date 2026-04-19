package base;

import org.testng.annotations.*;
import utils.ConfigReader;
import utils.Log;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Log.info("Starting Browser...");
        
        DriverFactory.initDriver(ConfigReader.get("browser"));
        DriverFactory.getDriver().get(ConfigReader.get("url"));
        DriverFactory.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        Log.info("Closing Browser...");
        DriverFactory.getDriver().quit();
    }
}