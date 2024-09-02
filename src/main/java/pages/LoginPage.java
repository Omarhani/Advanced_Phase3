package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By loginText= By.xpath("//h2[normalize-space()='Login to your account']");
    private final By emailField=By.name("email");
    private final By passwordField=By.name("password");
    private final By loginButton=By.xpath("//button[normalize-space()='Login']");

   //Actions
        public boolean loginTextVisible ()
    {
        return  isDisplayed(loginText,3);
    }
    private void insertEmail(String text)
    {
        sendKeys(emailField,3,text);
    }
    private void insertPassword( String text)
    {
        sendKeys(passwordField,3,text);
    }
    private void clickOnLoginButton()
    {
        click(loginButton,3);
    }
    public HomePage loginFeature(String email,String password)
    {
        insertEmail(email);
        insertPassword(password);
        clickOnLoginButton();
        return new HomePage(driver);

    }
}
