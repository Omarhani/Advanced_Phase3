package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage  {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public final By signUpAndLoginBtn = By.cssSelector("a[href='/login']");
    public final By homePageLinkText = By.xpath("//a[normalize-space()='Home']");



    @Step
    public String homePageVisible()
    {
        return driver.findElement(homePageLinkText).getText();
    }

    // Hello world

    @Step
    public RegisterPage clickOnSignUpAndLoginBtn(){
        driver.findElement(signUpAndLoginBtn).click();
        return new RegisterPage(driver);
    }

}