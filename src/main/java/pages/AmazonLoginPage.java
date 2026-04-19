package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class AmazonLoginPage extends BasePage {

    @FindBy(id = "nav-link-accountList")
    private WebElement signInBtn;

    @FindBy(id = "ap_email")
    private WebElement email;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "signInSubmit1")
    private WebElement loginBtn;

    public void login(String user, String pass) {

        ElementUtils.click(driver, signInBtn);
//        ElementUtils.sendKeys(driver, email, user);
//        ElementUtils.click(driver, continueBtn);
//        ElementUtils.sendKeys(driver, password, pass);
//        ElementUtils.click(driver, loginBtn);
    }
    public void clickSignIn() {
        ElementUtils.click(driver, signInBtn);
    }
    
}