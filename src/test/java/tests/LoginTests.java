package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.DriverManager;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage page = new SignupLoginPage(DriverManager.getDriver());

        String username = "user" + System.currentTimeMillis();
        String password = "test123";

        homePage.openSignupModal();
        page.waitForSignupModalVisible();
        page.signup(username, password);

        String signupAlert = page.handleSignupAlert();
        Assert.assertTrue(signupAlert.contains("Sign up successful"));

        homePage.openLoginModal();
        page.waitForLoginModalVisible();
        page.login(username, password);

        String welcomeText = page.getWelcomeText();
        Assert.assertTrue(welcomeText.contains("Welcome"));
    }

    @Test
    public void testLoginInvalidCredentials() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage page = new SignupLoginPage(DriverManager.getDriver());

        homePage.openLoginModal();
        page.waitForLoginModalVisible();
        page.clearLoginFields();
        page.login("invalidUser", "wrongPassword");

        String alertText = page.handleLoginAlert();
        Assert.assertTrue(
                alertText.toLowerCase().contains("wrong password")
                        || alertText.toLowerCase().contains("user does not exist")
        );
    }

    @Test
    public void testLoginWithEmptyFields() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        SignupLoginPage page = new SignupLoginPage(DriverManager.getDriver());

        homePage.openLoginModal();
        page.waitForLoginModalVisible();
        page.clearLoginFields();
        page.login("", "");

        String alertText = page.handleLoginAlert();
        Assert.assertTrue(
                alertText.toLowerCase().contains("please fill out username and password")
        );
    }
}