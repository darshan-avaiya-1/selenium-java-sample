package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class TestLoginTC1 extends BaseTest {

    @Test
    public void verifyUserIsAbleToLoginWithCorrectCredentials() {

        // Login to application with correct credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("darshan@test.com");
        loginPage.enterPassword("Aq@1234567890");
        loginPage.clickOnLoginButton();

        // validate my account heading
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getMyAccountTitle(), "My Account");
    }

}
