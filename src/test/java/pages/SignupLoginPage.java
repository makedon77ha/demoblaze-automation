package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class SignupLoginPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    private By signupUsername = By.id("sign-username");
    private By signupPassword = By.id("sign-password");
    private By signupButton = By.xpath("//button[text()='Sign up']");

    private By loginUsername = By.id("loginusername");
    private By loginPassword = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");

    private By signupModal = By.id("signInModal");
    private By loginModal = By.id("logInModal");
    private By welcomeUser = By.id("nameofuser");

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    public void signup(String username, String password) {
        waitHelper.waitForElementVisible(signupUsername).sendKeys(username);
        waitHelper.waitForElementVisible(signupPassword).sendKeys(password);
        waitHelper.waitForElementClickable(signupButton).click();
    }

    public void login(String username, String password) {
        waitHelper.waitForElementVisible(loginUsername).sendKeys(username);
        waitHelper.waitForElementVisible(loginPassword).sendKeys(password);
        waitHelper.waitForElementClickable(loginButton).click();
    }

    public void waitForSignupModalVisible() {
        waitHelper.waitForElementVisible(signupModal);
    }

    public void waitForLoginModalVisible() {
        waitHelper.waitForElementVisible(loginModal);
    }

    public String handleSignupAlert() {
        Alert alert = waitHelper.waitForAlert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public String handleLoginAlert() {
        Alert alert = waitHelper.waitForAlert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void clearLoginFields() {
        waitHelper.waitForElementVisible(loginUsername).clear();
        waitHelper.waitForElementVisible(loginPassword).clear();
    }

    public String getWelcomeText() {
        return waitHelper.waitForElementVisible(welcomeUser).getText();
    }
}