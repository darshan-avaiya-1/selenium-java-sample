package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

    // locators
    By adminMenuLocator = By.xpath("//a[contains(., 'Admin')]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnAdminMenu() {
        clickElement(adminMenuLocator);
    }

}
