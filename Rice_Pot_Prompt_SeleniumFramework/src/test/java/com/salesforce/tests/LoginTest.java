package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.doLogin("valid_user@test.com", "ValidPass123!");
        } catch (Exception e) {
            Assert.fail("Valid Login Exception: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.doLogin("invalid_user@test.com", "WrongPass");

            String errorMsg = loginPage.getErrorMessage();
            Assert.assertNotNull(errorMsg);
            Assert.assertTrue(errorMsg.contains("Please check your username and password"));
        } catch (Exception e) {
            Assert.fail("Invalid Login Exception: " + e.getMessage());
        }
    }
}
