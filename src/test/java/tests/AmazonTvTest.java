package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.CartPage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class AmazonTvTest extends BaseTest {

    @Test
    public void verifyTvPriceInCart() {

        AmazonHomePage homePage = new AmazonHomePage();
        SearchResultsPage resultsPage = new SearchResultsPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        //Step 1. Search product
        homePage.searchProduct("TV");

        // Step 2. Select 3rd item from the search result
        String expectedPrice = resultsPage.selectThirdProductAndGetPrice();

        // Step 3. Add the item to the cart
        productPage.addToCart();

        // Step 4. Go to cart
        productPage.goToCart();

        // Step 5. Get price from cart
        String actualPrice = cartPage.getCartPrice();

        // Step 6. Verify expected with actual price
        Assert.assertEquals(actualPrice, expectedPrice, "Price mismatch between search result and cart");
    }
}
