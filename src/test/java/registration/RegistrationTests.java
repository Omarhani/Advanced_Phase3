package registration;

import base.BaseTests;
import data.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.FileNotFoundException;

public class RegistrationTests extends BaseTests {


    LoginPage log;
    RegisterPage register;

    @Test
    public void testRegisterUserTC1() throws FileNotFoundException {

            Assert.assertTrue(homePage.homePageVisible(),"Home page is not visible");

            log = homePage.clickOnSignUpAndLoginLink();


            register = registerPage;
            Assert.assertEquals(register.userSignUpTextVisible() , "New User Signup!");
            register.insertRegisterName(dataModel().Registration.ValidCredentials.RegisterName);
            register.insertRegisterEmail(dataModel().Registration.ValidCredentials.RegisterEmail);
            register.clickOnRegisterBtn();


            Assert.assertEquals(register.getEnterAccountEInfoText() , "ENTER ACCOUNT INFORMATION");

            register.registerAccountForm(dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.RegisterAccountPassword
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.RegisterBirthDay
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.RegisterBirthMonth
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.RegisterBirthYear
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.FirstNameAddressA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.LastNameAddressA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.CompanyNameAddressA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.AddressNameA1
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.AddressNameA2
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.CountryAddressA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.StateA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.CityA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.ZipCodeA
                    ,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.MobileNumberA);




            Assert.assertEquals(register.accountCreatedTxtVisible() , "ACCOUNT CREATED!");
            register.clickOnContinueBtn();


            Assert.assertEquals(register.loggedInUserNameTxtVisible() , "Logged in as ibrahim");



            register.clickOnDeleteAccount();
            Assert.assertEquals(register.accountDeletedTxtVisible() , "ACCOUNT DELETED!");
            register.clickOnContinueDeleteBtn();

        }

}
