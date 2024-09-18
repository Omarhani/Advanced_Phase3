package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.MethodHandles;

public class ProductsPage extends MethodHandles {
    Actions actions = new Actions(driver);
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    // Locators
    private  final By productsPage = By.xpath("//a[@href='/products' and contains(@style, 'color: orange;')]");
    private  final By productsDetailsLink = By.xpath("//a[@href='/product_details/1' and contains(@style, 'color: brown;')]");
    private  final By addProductOneToCart =By.xpath("//div[@class='product-image-wrapper'][1]//a[@class='btn btn-default add-to-cart' and @data-product-id='1']");
    private final By continueShoppingBtn= By.xpath("//button[@class='btn btn-success close-modal btn-block' and text()='Continue Shopping']");
    private  final By addProductSecondToCart =By.xpath("//a[@class='btn btn-default add-to-cart' and @data-product-id='2']");

    //Actions
    public boolean productsPageVisible() {

        return isDisplayed(productsPage, 3);
    }
    public ProductsDetailsPage  clickProductsDetailsPage()
    {
        click(productsDetailsLink,3);
        return new ProductsDetailsPage(driver);
    }
    public void clickContinueShoppingBtn(){
        click(continueShoppingBtn,3);

    }


    public PopupPage clickAddProductOneToCart(){
         click(addProductOneToCart,3);
        return new PopupPage(driver);
    }

    public PopupPage clickAddProductSecondToCart (){
        click(addProductSecondToCart,3);
        return new PopupPage(driver);
    }

}

