package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class TestLoginTC2 extends BaseTest {

    @Test
    public void verifyUserIsNotAbleToLoginWithInCorrectCredentials() {

        // Login to application with incorrect credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("darshan1@test.com");
        loginPage.enterPassword("Aq@12345678901");
        loginPage.clickOnLoginButton();

        // Validate error message
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("no match for e-mail address"));
    }

}
