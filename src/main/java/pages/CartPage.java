package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CartPage extends MethodHandles {

    public CartPage (WebDriver driver) {
        super(driver);
    }

    private final By product1=By.xpath("//tr[@id='product-1']//h4/a[text()='Blue Top']");
    private final By product2=By.xpath("//tr[@id='product-2']//h4/a[text()='Men Tshirt']");


    public boolean verifyProduct1(){
     return    isDisplayed(product1,3);

    }

    public boolean verifyProduct2(){
     return    isDisplayed(product2,3);

    }
}


