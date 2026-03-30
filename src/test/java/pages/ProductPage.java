package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ProductPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    private By productTitle = By.cssSelector(".name");
    private By productPrice = By.cssSelector(".price-container");
    private By addToCartButton = By.linkText("Add to cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    public String getProductTitle() {
        return waitHelper.waitForElementVisible(productTitle).getText();
    }

    public String getProductPrice() {
        return waitHelper.waitForElementVisible(productPrice).getText();
    }

    public void clickAddToCart() {
        waitHelper.waitForElementClickable(addToCartButton).click();
    }

    public String handleAlert() {
        Alert alert = waitHelper.waitForAlert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}