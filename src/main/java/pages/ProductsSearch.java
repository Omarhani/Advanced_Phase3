package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductsSearch extends MethodHandles {

    public ProductsSearch(WebDriver driver) {
        super(driver);
    }


    private final By SearchedProductsText = By.cssSelector(".title.text-center");
    private final By RelatedSearchProduct = By.cssSelector(".google-anno-t");


    public String getSearchedProductsTxt(){
        return getText(SearchedProductsText , 3);
    }

    public boolean getRelatedSearchProduct(){
        return isDisplayed(RelatedSearchProduct , 3);
    }



}
