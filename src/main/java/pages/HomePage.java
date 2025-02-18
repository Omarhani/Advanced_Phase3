package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.MethodHandles;
import utils.ProductOverlay;

import javax.swing.*;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Locators
    Actions action;
    private final By signUpAndLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By homePageLink = By.xpath("//a[normalize-space()='Home']");
    private final By loggedLabel = By.xpath("//a[contains(normalize-space(),'Logged in as')]");
    private final By deleteAccountLink=By.linkText("Delete Account");
    private final By testCaseLink = By.cssSelector("a[href='/test_cases']");
    private  final By productsLink = By.xpath("//a[@href='/products']");
    private final By viewCartBtn = By.cssSelector("#cartModal .modal-body a");
    private final By continueShoppingtBtn = By.cssSelector("#cartModal .modal-footer .btn");
    private final By product = By.cssSelector(".single-products");
    private final By productOverlay = By.cssSelector(".product-overlay .overlay-content");



    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    private final By getSubscriptionTxt = By.cssSelector("div[class='single-widget'] h2");
    private final By enterEmailAddressInput = By.cssSelector("#susbscribe_email");
    private final By subscriptionArrowBtn = By.cssSelector("#subscribe");
    private final By successfulMessageTxt = By.cssSelector(".alert-success.alert");
    private final By cartLinkPage = By.cssSelector("body > header:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");





    //Actions
    public boolean homePageVisible() {
        return isDisplayed(homePageLink, 3);
    }
    public LoginPage clickOnSignUpAndLoginLink()
    {
        click(signUpAndLoginLink,3);
        return new LoginPage(driver);

    }
    public String getLoggedUsername() {

        return getText(loggedLabel,3);
    }

    public DeleteAccountPage clickOnDeleteAccount()
    {
        click(deleteAccountLink,3);
        return new DeleteAccountPage(driver);
    }

    public LoginPage clickOnLogoutLink()
    {
        click(logoutLink,3);
        return new LoginPage(driver);
    }
    public ProductsPage  clickProductsLinkLink()
    {
        click(productsLink,3);
        return new ProductsPage(driver);
    }


    public ContactUsPage clickOnContactUsLink(){
        click(contactUsLink,3);
        return new ContactUsPage(driver);
    }

    public TestCasePage clickOnTestCaseBtn(){
        click(testCaseLink , 3);
        return new TestCasePage(driver);
    }

    public ProductOverlay addProductToViewCart(int index){
        WebElement element=driver.findElements(product).get(index-1);
        action=new Actions(driver);
        action.moveToElement(element).build().perform();
        return new ProductOverlay(element.findElement(productOverlay));
    }

    public ViewCartPage clickOnCartPage(){
        click(cartLink,5);
        return new ViewCartPage(driver);
    }
    public void clickOnContinueShoppingBtn(){
        click(continueShoppingtBtn,5);
    }
    public ViewCartPage clickOnViewCartbtn(){
        click(viewCartBtn,5);
        return new ViewCartPage(driver);
    }


    public String getSubscriptionText(){
        return getText(getSubscriptionTxt , 3);
    }

    public void insertEmailAddressText(String emailAddress ){
        sendKeys(enterEmailAddressInput , 3 , emailAddress);
    }

    public void clickOnSubscriptionArrowBtn(){
        click(subscriptionArrowBtn , 3);
    }

    public boolean getSuccessfulMessageTxt(){
        return isDisplayed(successfulMessageTxt , 3);
    }

    public ProductsCart clickOnCartLinkPage(){
        click(cartLinkPage , 3);
        return new ProductsCart(driver);
    }










}
