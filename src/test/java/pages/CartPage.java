package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WaitHelper waitHelper;

    private By cartRows = By.cssSelector("#tbodyid tr");
    private By totalPrice = By.id("totalp");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By deleteLinks = By.linkText("Delete");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    public int getCartItemsCount() {
        List<WebElement> items = driver.findElements(cartRows);
        return items.size();
    }

    public String getTotalPrice() {
        return waitHelper.waitForElementVisible(totalPrice).getText();
    }

    public void clickPlaceOrder() {
        waitHelper.waitForElementClickable(placeOrderButton).click();
    }

    public void deleteItem(int index) {
        List<WebElement> deleteButtons = driver.findElements(deleteLinks);
        if (index >= 0 && index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        } else {
            throw new IllegalArgumentException("Invalid item index: " + index);
        }
    }
}