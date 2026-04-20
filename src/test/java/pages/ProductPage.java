package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{

    private final By addToCartButton = By.id("add-to-cart-button");
    private final By cartButton = By.id("nav-cart");
    private final By noThanksButton = By.id("attachSiNoCoverage");

    public ProductPage(){
        super();
    }

    public void addToCart(){

        System.out.println("Current page title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Add to cart elements found: " + driver.findElements(addToCartButton).size());
        click(addToCartButton);

        try {
            click(noThanksButton);
        } catch (Exception e) {
            System.out.println("Protection popup did not appear.");
        }

    }

    public void goToCart(){
        waitForVisible(cartButton);
        waitForUrlContains("cart");
        click(cartButton);
    }
}
