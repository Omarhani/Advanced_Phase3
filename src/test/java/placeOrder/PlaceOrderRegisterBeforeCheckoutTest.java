package placeOrder;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ProductOverlay;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class PlaceOrderRegisterBeforeCheckoutTest extends BaseTests {
    @Test
    public void testPlaceOrderRegisterBeforeCheckout() throws FileNotFoundException {
        assertTrue(homePage.homePageVisible(),"Home page is not visible");
        LoginPage loginPage=homePage.clickOnSignUpAndLoginLink();
        RegisterPage1 registerPage1=loginPage.redirectToRegisterPage(dataModel().Registration2.RegisterEmail,dataModel().Registration2.RegisterName);
        AccountCreatedPage accountCreatedPage=registerPage1.registerFeature(dataModel().Registration2.RegisterAccountPassword,dataModel().Registration2.FirstNameAddressA,dataModel().Registration2.LastNameAddressA,dataModel().Registration2.AddressNameA1,dataModel().Registration2.CountryAddressA,dataModel().Registration2.StateA,dataModel().Registration2.CityA,dataModel().Registration2.ZipCodeA,dataModel().Registration2.MobileNumberA);
        Assert.assertEquals(accountCreatedPage.accountCreatedTxtVisible() , "ACCOUNT CREATED!");
        HomePage homePage1=accountCreatedPage.clickOnContinueBtn();
        Assert.assertEquals(homePage1.getLoggedUsername(),"Logged in as "+dataModel().Registration2.RegisterName);
        ProductOverlay productOverlay =homePage1.addProductToViewCart(2);
        productOverlay.clickOnAddToCartBtn();
        homePage1.clickOnContinueShoppingBtn();
        ViewCartPage viewCartPage=homePage1.clickOnCartPage();
        assertTrue(viewCartPage.isCartDisplayed(),"Cart page is not visible");
        CheckoutPage checkoutPage=viewCartPage.redirectToCheckoutPage();
        assertTrue(checkoutPage.isAddressLabelVisible(),"Address is not visible");
        assertTrue(checkoutPage.isReviewLabelVisible(),"Review is not visible");
        PaymentPage paymentPage=checkoutPage.checkoutFeature("123");
        PaymentDonePage paymentDonePage=paymentPage.paymentFeature("132132123","12313","123","12","12312");
        assertTrue(paymentDonePage.getPaymentSuccessMessage().contains("Congratulations! Your order has been confirmed!"));
        DeleteAccountPage deleteAccountPage=paymentDonePage.clickOnDeleteAccount();
        Assert.assertEquals(deleteAccountPage.getMessageDelete() , "ACCOUNT DELETED!");
    }
}
