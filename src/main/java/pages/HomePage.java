package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

    // locators
    By myAccountHeadingLocator = By.xpath("//*[@id='account-account']//h2[1]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getMyAccountTitle() {
        return getText(myAccountHeadingLocator);
    }

}
