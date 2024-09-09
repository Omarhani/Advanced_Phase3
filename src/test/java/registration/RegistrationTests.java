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


            register.clickOnTitleBox();
            register.insertPassword(dataModel().AccountInfo.ValidRegisterAccountCredentials.RegisterAccountPassword);


            register.insertBirthDate1(dataModel().DateOfBirth.ValidRegisterBirthCredentials.RegisterBirthDay);
            register.insertBirthDate2(dataModel().DateOfBirth.ValidRegisterBirthCredentials.RegisterBirthMonth);
            register.insertBirthDate3(dataModel().DateOfBirth.ValidRegisterBirthCredentials.RegisterBirthYear);


            register.checkOnSignUpNewsletter();
            register.checkOnReceiveSpecialOffers();


            register.insertFirstNameAddress(dataModel().AddressInfo.ValidRegisterAddressCredentials.FirstNameAddressA);
            register.insertLastNameAddress(dataModel().AddressInfo.ValidRegisterAddressCredentials.LastNameAddressA);
            register.insertCompanyNameAddress(dataModel().AddressInfo.ValidRegisterAddressCredentials.CompanyNameAddressA);
            register.insertAddressName1(dataModel().AddressInfo.ValidRegisterAddressCredentials.AddressNameA1);
            register.insertAddressName2(dataModel().AddressInfo.ValidRegisterAddressCredentials.AddressNameA2);
            register.insertCountryAddress(dataModel().AddressInfo.ValidRegisterAddressCredentials.CountryAddressA);
            register.insertState(dataModel().AddressInfo.ValidRegisterAddressCredentials.StateA);
            register.insertCity(dataModel().AddressInfo.ValidRegisterAddressCredentials.CityA);
            register.insertZipCode(dataModel().AddressInfo.ValidRegisterAddressCredentials.ZipCodeA);
            register.insertMobileNumber(dataModel().AddressInfo.ValidRegisterAddressCredentials.MobileNumberA);
            register.clickOnCreateAccountBtn();


            Assert.assertEquals(register.accountCreatedTxtVisible() , "ACCOUNT CREATED!");
            register.clickOnContinueBtn();


            Assert.assertEquals(register.loggedInUserNameTxtVisible() , "Logged in as ibrahim");



            register.clickOnDeleteAccount();
            Assert.assertEquals(register.accountDeletedTxtVisible() , "ACCOUNT DELETED!");
            register.clickOnContinueDeleteBtn();

        }

}
