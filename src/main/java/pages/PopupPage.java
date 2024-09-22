package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class PopupPage extends MethodHandles {
    public PopupPage(WebDriver driver) {
        super(driver);
    }
    private final By massageAdd=By.xpath("//p[@class='text-center' and text()='Your product has been added to cart.']");
    private final By viewCartBtn=By.xpath("//u[text()='View Cart']");


    public String getMassageAdd() {
        return getText(massageAdd,3);
    }

public CartPage clickViewCartBtn(){
        click(viewCartBtn,3);
        return new CartPage(driver);
}

}
