package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    // locators
    By usernameValueLocator = By.xpath("//p[contains(.,'Username')]");
    By passwordValueLocator = By.xpath("//p[contains(.,'Password')]");
    By usernameLocator = By.xpath("//input[@name='username']");
    By passwordLocator = By.xpath("//input[@name='password']");
    By loginButtonLocator = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getUsername() {
        return getText(usernameValueLocator).split(":")[1].trim();
    }

    public String getPassword() {
        return getText(passwordValueLocator).split(":")[1].trim();
    }

    public void enterUserName() {
        enterText(usernameLocator, getUsername());
    }

    public void enterPassword() {
        enterText(passwordLocator, getPassword());
    }

    public void clickOnLoginButton() {
        clickElement(loginButtonLocator);
    }

}
