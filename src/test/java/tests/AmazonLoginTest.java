package tests;

import base.BaseTest;
import pages.AmazonLoginPage;
import utils.DataProviderUtils;

import org.testng.annotations.Test;

public class AmazonLoginTest extends BaseTest {

	  @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void clickSignInTest() {

        AmazonLoginPage login = new AmazonLoginPage();

        login.clickSignIn();

        System.out.println("Clicked on Sign In successfully");
    }
}