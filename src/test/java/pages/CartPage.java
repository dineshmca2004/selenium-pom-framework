package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;



public class CartPage extends BasePage {

    private final By cartPrice = By.cssSelector("span.sc-product-price");

    public CartPage(){
        super();
    }

    public String getCartPrice() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.println(" attempt " + attempts );
            System.out.println("________________________");
            try {
                return waitForVisible(cartPrice)
                        .getText()
                        .replace("$", "")
                        .trim();
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to read cart price");
    }

}
