package pages;

import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage{

    By searchBox = By.id("twotabsearchtextbox");
    By clickSearchBtn = By.id("nav-search-submit-button");

    public AmazonHomePage(){
        super();
    }

    public void searchProduct(String itemTobeSearch){
        type(searchBox, itemTobeSearch);
        click(clickSearchBtn);
    }

}

