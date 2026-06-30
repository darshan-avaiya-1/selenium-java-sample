package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    // locators
    By usernameLocator = By.xpath("//*[@id='input-email']");
    By passwordLocator = By.xpath("//*[@id='input-password']");
    By loginButtonLocator = By.xpath("//*[@value='Login']");
    By loginErrorMessageLocator = By.xpath("//*[contains(@class,'alert-danger')]");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUserName(String username) {
        enterText(usernameLocator, username);
    }

    public void enterPassword(String password) {
        enterText(passwordLocator, password);
    }

    public void clickOnLoginButton() {
        clickElement(loginButtonLocator);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessageLocator).toLowerCase();
    }
}
