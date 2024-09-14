package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class RegisterTests extends BaseTests {
    @Test
    public void testRegisterUserWithExistingEmail() throws FileNotFoundException {
        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.homePageVisible(),"Home page is not visible");
        // Click on 'Signup / Login' button
        LoginPage loginPage=homePage.clickOnSignUpAndLoginLink();
        //Verify 'Login to your account' is visible
        Assert.assertTrue(loginPage.newUserTextVisible(),"'New User Signup!' is not visible");
        //  Enter name and already registered email address and then Click On 'Signup' button
        String nameEmail= (dataModel().Login.ValidCredentials.Email).split("@")[0];
        loginPage.signupFeature(dataModel().Login.ValidCredentials.Email,nameEmail);
        //Verify error 'Email Address already exist!' is visible
      Assert.assertEquals(loginPage.getValidationSignup(),"Email Address already exist!");
    }
}
