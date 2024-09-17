package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ViewCartPage;

import java.io.FileNotFoundException;

public class CartTests extends BaseTests {

    @Test
    public void testSubscriptionInCart() throws FileNotFoundException {
        Assert.assertTrue(homePage.homePageVisible(),"Home page is not visible");
        ViewCartPage viewCartPage=homePage.clickOnCartLink();
        viewCartPage.scrollToFooter();
        Assert.assertTrue(viewCartPage.verifySubscriptionIsVisible(), "Subscription Text is not visible");
        viewCartPage.featureSendEmailSubscription(dataModel().Login.ValidCredentials.Email);
        Assert.assertEquals(viewCartPage.verifySuccessMessage(), "You have been successfully subscribed!");
        

    }

}
