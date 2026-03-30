package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.DriverManager;

public class SignupTests extends BaseTest {

    @Test
    public void testSuccessfulSignup() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage signupPage = new SignupLoginPage(DriverManager.getDriver());

        homePage.openSignupModal();
        signupPage.waitForSignupModalVisible();

        String username = "user" + System.currentTimeMillis();
        String password = "test123";

        signupPage.signup(username, password);

        String alertText = signupPage.handleSignupAlert();
        Assert.assertTrue(alertText.contains("Sign up successful"));
    }

    @Test
    public void testSignupExistingUser() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage signupPage = new SignupLoginPage(DriverManager.getDriver());

        homePage.openSignupModal();
        signupPage.waitForSignupModalVisible();

        String username = "testuser";
        String password = "test123";

        signupPage.signup(username, password);

        String alertText = signupPage.handleSignupAlert();
        Assert.assertTrue(alertText.contains("already exist"));
    }

    @Test
    public void testSignupWithEmptyFields() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage signupPage = new SignupLoginPage(DriverManager.getDriver());

        homePage.openSignupModal();
        signupPage.waitForSignupModalVisible();

        signupPage.signup("", "");

        String alertText = signupPage.handleSignupAlert();
        Assert.assertTrue(
                alertText.toLowerCase().contains("please fill out username and password")
        );
    }
}