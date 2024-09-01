package registrationPage;

import base.BaseTests;
import base.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static utils.DataDriven.JsonClass.readJson;

@Listeners(TestListeners.class)
public class RegistartionTests extends BaseTests {


    String regFile = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\RegisterData.json";
    String accountInfoFile = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\AccountInfo.json";
    String addressInfoFile = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\AddressInfo.json";


    @Test
    public void TestCase1RegisterUser(){

        RegisterPage register = homePage.clickOnSignUpAndLoginBtn();
        Assert.assertEquals(register.userSignUpTextVisible() , "New User Signup!");
        register.insertRegisterName(readJson(regFile , "Name"));
        register.insertRegisterEmail(readJson(regFile , "Email"));
        register.clickOnRegisterBtn();

        Assert.assertEquals(register.getEnterAccountEInfoText() , "ENTER ACCOUNT INFORMATION");


        register.clickOnTitleBox();
        register.insertName(readJson(accountInfoFile , "Name1"));
        register.insertPassword(readJson(accountInfoFile , "Pass1"));


        register.insertBirthDate1("1");
        register.insertBirthDate2("January");
        register.insertBirthDate3("2021");


        register.checkOnSignUpNewsletter();
        register.checkOnReceiveSpecialOffers();



        register.insertFirstNameAddress(readJson(addressInfoFile , "FirstNameAddressA"));
        register.insertLastNameAddress(readJson(addressInfoFile , "LastNameAddressA"));
        register.insertCompanyNameAddress(readJson(addressInfoFile , "CompanyNameAddressA"));
        register.insertAddressName1(readJson(addressInfoFile , "AddressNameA1"));
        register.insertAddressName2(readJson(addressInfoFile , "AddressNameA2"));
        register.insertCountryAddress(readJson(addressInfoFile , "CountryAddressA"));
        register.insertState(readJson(addressInfoFile , "StateA"));
        register.insertCity(readJson(addressInfoFile , "CityA"));
        register.insertZipCode(readJson(addressInfoFile , "ZipCodeA"));
        register.insertMobileNumber(readJson(addressInfoFile , "MobileNumberA"));
        register.clickOnCreateAccountBtn();


        Assert.assertEquals(register.accountCreatedTxtVisible() , "ACCOUNT CREATED!");
        register.clickOnContinueBtn();


        Assert.assertEquals(register.loggedInUserNameTxtVisible() , "Logged in as ibrahim");

        register.clickOnDeleteAccount();
        Assert.assertEquals(register.accountDeletedTxtVisible() , "ACCOUNT DELETED!");
        register.clickOnContinueDeleteBtn();
    }

}
