package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverManager;

public class ProductTests extends BaseTest {

    @Test
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");

        String productTitle = productPage.getProductTitle();
        Assert.assertEquals(productTitle, "Samsung galaxy s6");

        productPage.clickAddToCart();
        String alertText = productPage.handleAlert();

        Assert.assertTrue(alertText.contains("Product added"));
    }

    @Test
    public void testProductPriceDisplay() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");

        String priceText = productPage.getProductPrice();
        Assert.assertTrue(priceText.contains("$"));
    }

    @Test
    public void testProductTitleDisplay() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());

        homePage.clickProduct("Samsung galaxy s6");

        String productTitle = productPage.getProductTitle();
        Assert.assertFalse(productTitle.isEmpty());
        Assert.assertEquals(productTitle, "Samsung galaxy s6");
    }
}