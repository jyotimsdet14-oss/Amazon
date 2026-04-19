package tests;

import base.BaseTest;
import pages.*;
import utils.*;
import org.testng.annotations.Test;

import java.util.Map;

public class AmazonE2ETest extends BaseTest {

    @Test(dataProvider = "excelData",
          dataProviderClass = DataProviderUtils.class,
          retryAnalyzer = utils.RetryAnalyzer.class)

    public void test(Map<String, String> data) {

        AmazonLoginPage login = new AmazonLoginPage();
       
        login.login(data.get("Email"), data.get("Password"));

      

    
    }
}