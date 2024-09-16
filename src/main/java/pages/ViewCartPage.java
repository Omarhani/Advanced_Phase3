package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class ViewCartPage extends MethodHandles {

    public ViewCartPage(WebDriver driver)
    {
        super(driver);
    }

    private final By subscriptionText= By.xpath("//h2[text()='Subscription']");
    private final By emailField = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By successMessage = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");


    public void scrollToFooter() {
        getLocation(subscriptionText,3);
    }
    public boolean verifySubscriptionIsVisible()
    {
        return isDisplayed(subscriptionText,2);
    }
    private void insertEmail(String email)
    {
        sendKeys(emailField,3,email);
    }
    private void clickOnArrowButton()
    {
        click(arrowButton,3);
    }
    public void featureSendEmailSubscription(String email)
    {
        insertEmail(email);
        clickOnArrowButton();
    }

    public String verifySuccessMessage()
    {
        return getText(successMessage,3);
    }
}
