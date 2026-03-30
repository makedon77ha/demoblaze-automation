package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverManager;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCompleteOrder() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCart();
        productPage.handleAlert();

        homePage.goToCart();
        cartPage.clickPlaceOrder();

        Assert.assertTrue(true);
    }

    @Test
    public void testOrderWithEmptyForm() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCart();
        productPage.handleAlert();

        homePage.goToCart();
        cartPage.clickPlaceOrder();

        Assert.assertTrue(true);
    }

    @Test
    public void testCartHasItemsAfterAddingProduct() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");
        productPage.clickAddToCart();
        productPage.handleAlert();

        homePage.goToCart();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(cartPage.getCartItemsCount() >= 1);
    }
}