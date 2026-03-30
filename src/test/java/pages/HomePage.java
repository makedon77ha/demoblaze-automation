package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class HomePage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    private By phonesCategory = By.linkText("Phones");
    private By laptopsCategory = By.linkText("Laptops");
    private By monitorsCategory = By.linkText("Monitors");
    private By signupLink = By.id("signin2");
    private By loginLink = By.id("login2");
    private By cartLink = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    public void clickCategory(String category) {
        switch (category.toLowerCase()) {
            case "phones":
                waitHelper.waitForElementClickable(phonesCategory).click();
                break;
            case "laptops":
                waitHelper.waitForElementClickable(laptopsCategory).click();
                break;
            case "monitors":
                waitHelper.waitForElementClickable(monitorsCategory).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    public void clickProduct(String productName) {
        By productLink = By.linkText(productName);
        waitHelper.waitForElementClickable(productLink).click();
    }

    public void openSignupModal() {
        waitHelper.waitForElementClickable(signupLink).click();
    }

    public void openLoginModal() {
        waitHelper.waitForElementClickable(loginLink).click();
    }

    public void goToCart() {
        waitHelper.waitForElementClickable(cartLink).click();
    }
}