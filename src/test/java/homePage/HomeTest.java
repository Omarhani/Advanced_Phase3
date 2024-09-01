package homePage;
import base.BaseTests;
import base.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import static utils.DataDriven.JsonClass.readJson;

@Listeners(TestListeners.class)
public class HomeTest extends BaseTests {


    @Test
    public void TestHomePageIsVisible(){

        HomePage homePage1 = homePage;
        Assert.assertEquals(homePage1.homePageVisible() , "Home");
        homePage1.clickOnSignUpAndLoginBtn();
    }
}
