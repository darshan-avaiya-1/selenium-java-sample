package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class AdminPage extends BasePage {

    // Locators
    private By allTableBodyRowLocator = By.xpath("//div[@role='rowgroup']//div[@role='row']");
    private By deleteIconLocator = By.xpath(".//button[i[contains(@class,'bi-trash')]]");
    private By yesDeleteButtonLocator = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By cellLocator = By.xpath(".//div[@role='cell']");
    private By toastMessageLocator = By.xpath("//*[contains(@class,'toast-message')]");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String clickOnDeleteIcon(int index) {

        List<WebElement> rowList = driver.findElements(allTableBodyRowLocator);

        int nonAdminCount = 0;

        for (WebElement row : rowList) {

            List<WebElement> cells = row.findElements(cellLocator);

            // Skip header/invalid rows
            if (cells.size() < 2) {
                continue;
            }

            String username = cells.get(1).getText().trim();

            // Skip admin user
            if (username.equalsIgnoreCase("admin")) {
                continue;
            }

            if (nonAdminCount == index) {

                row.findElement(deleteIconLocator).click();

                return username;
            }

            nonAdminCount++;
        }

        throw new RuntimeException("Non-admin user not found at index : " + index);
    }

    public void clickOnYesDeleteButton() {
        clickElement(yesDeleteButtonLocator);
    }

    public boolean isUserPresent(String username) {

        List<WebElement> rowList = driver.findElements(allTableBodyRowLocator);

        for (WebElement row : rowList) {

            List<WebElement> cells = row.findElements(cellLocator);

            if (cells.size() < 2) {
                continue;
            }

            String actualUsername = cells.get(1).getText().trim();

            if (actualUsername.equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    public String getToastMessage() {
        return getText(toastMessageLocator);
    }
}