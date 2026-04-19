package listeners;

import org.testng.*;
import utils.*;
import base.DriverFactory;
import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtils.capture(DriverFactory.getDriver(), result.getName());
        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(path);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}