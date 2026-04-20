package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage{

    /*
    define locator
    Used CSS selectors because, we dont have stable IDs in the search results
    Amazon search page is dynamic, i.e There is no unique ID for each product card.
     so used CSS as it is more reliable.
    */
    private  final By productResults = By.cssSelector("div[data-component-type='s-search-result']");
    private final By wholePrice = By.cssSelector("span.a-price-whole");
    private final By fractionPrice = By.cssSelector("span.a-price-fraction");
    private final By productLink = By.cssSelector("a[href*='/dp/']");

    public SearchResultsPage() {
        super();
    }

    public String selectThirdProductAndGetPrice(){
        List<WebElement> results = driver.findElements(productResults);
        System.out.println("Total results found: " + results.size());

        /* debug steps
      for (WebElement product : results) {
        index++;
        System.out.println("Checking result #" + index);
        System.out.println("Links found: " + product.findElements(By.cssSelector("h2 a")).size());
        System.out.println("Whole price found: " + product.findElements(wholePrice).size());
        System.out.println("Fraction price found: " + product.findElements(fractionPrice).size());
        System.out.println("--------------------------------");
    }

        goal is to find the link that land into product detail page

        WebElement firstProduct = results.get(0);

        List<WebElement> links = firstProduct.findElements(By.tagName("a"));
        System.out.println("Total anchors in first product: " + links.size());

        for (WebElement link : links) {
            System.out.println("Link text: " + link.getText());
            System.out.println("Href: " + link.getAttribute("href"));
            System.out.println("------------------");
        }

         */

        // select 3rd item
        WebElement thirdProduct = results.get(2);
        String whole = thirdProduct.findElement(wholePrice).getText();
        String fraction = thirdProduct.findElement(fractionPrice).getText();
        String price = whole + "." + fraction;

        thirdProduct.findElement(productLink).click();

        return price;
    }


}
