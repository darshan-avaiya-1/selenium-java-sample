package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class TestLoginTC1 extends BaseTest {

    @Test
    public void verifyUserIsAbleToLoginWithCorrectCredentials() throws InterruptedException {

        // Login to application with correct credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();

        // click on Admin menu from home/dashboard page
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAdminMenu();

        // Delete 2nd non-admin user
        AdminPage adminPage = new AdminPage(driver);
        String username = adminPage.clickOnDeleteIcon(1);

        // Click Yes delete option on delete confirmation popup
        adminPage.clickOnYesDeleteButton();

        // Validate that user is deleted
        System.out.print(adminPage.getToastMessage());
        Assert.assertTrue(adminPage.getToastMessage().contains("Successfully Deleted"));
        Assert.assertFalse(adminPage.isUserPresent(username));
    }

}
