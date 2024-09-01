package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.MethodHandles;

public class RegisterPage {


    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    Select select;

    public final By userSignUpText = By.cssSelector("div[class='signup-form'] h2");
    public final By registerName = By.name("name");
    public final By registerEmail = By.cssSelector("input[data-qa='signup-email']");
    public final By registerBtn = By.cssSelector("button[data-qa='signup-button']");
    public final By enterAccountText = By.xpath("//b[normalize-space()='Enter Account Information']");

    public final By fillTitle = By.cssSelector("#id_gender1");
    public final By fillName = By.cssSelector("#name");
    public final By fillEmail = By.cssSelector("#email");
    public final By fillPassword = By.cssSelector("#password");
    public final By fillDateOfBirth1 = By.id("days");
    public final By fillDateOfBirth2 = By.id("months");
    public final By fillDateOfBirth3 = By.id("years");
    public final By clickSignUpNewsletter = By.id("newsletter");
    public final By clickReceiveSpecialOffers = By.cssSelector("#optin");
    public final By firstNameAddress = By.name("first_name");
    public final By lastNameAddress = By.name("last_name");
    public final By companyAddress = By.name("company");
    public final By AddressName1 = By.name("address1");
    public final By AddressName2 = By.name("address2");
    public final By countryName = By.name("country");
    public final By stateName = By.name("state");
    public final By cityName = By.name("city");
    public final By zipcodeName = By.name("zipcode");
    public final By mobileNumber1 = By.name("mobile_number");
    public final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    public final By accountCreatedText = By.xpath("//h2[@class='title text-center']/b");
    public final By continueBtn = By.linkText("Continue");
    public final By loggedInUserName = By.cssSelector("li:nth-child(10) a:nth-child(1)");
    public final By deleteAccountBtn = By.cssSelector("a[href='/delete_account']");
    public final By accountDeletedText = By.cssSelector("h2[class='title text-center'] b");
    public final By continueDeleteBtn = By.linkText("Continue");



    @Step
    public String userSignUpTextVisible(){
        return driver.findElement(userSignUpText).getText();
    }

    @Step
    public RegisterPage insertRegisterName(String name){
        driver.findElement(registerName).sendKeys(name);
        return this;
    }

    @Step
    public RegisterPage insertRegisterEmail(String email){
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }

    @Step
    public RegisterPage clickOnRegisterBtn(){
        driver.findElement(registerBtn).click();
        return this;
    }

    @Step
    public String getEnterAccountEInfoText(){
        return driver.findElement(enterAccountText).getText();
    }

    @Step
    public RegisterPage clickOnTitleBox(){
        driver.findElement(fillTitle).click();
        return this;
    }


    @Step
    public RegisterPage insertName(String name1){
        driver.findElement(fillName).clear();
        driver.findElement(fillName).sendKeys(name1);
        return this;
    }

    @Step
    public RegisterPage insertEmail(String email1){
        driver.findElement(fillEmail).clear();
        driver.findElement(fillEmail).sendKeys(email1);
        return this;
    }


    @Step
    public RegisterPage insertPassword(String pass1){
        driver.findElement(fillPassword).sendKeys(pass1);
        return this;
    }

    @Step
    public RegisterPage checkOnSignUpNewsletter(){
        driver.findElement(clickSignUpNewsletter).click();
        return this;
    }

    @Step
    public RegisterPage checkOnReceiveSpecialOffers(){
        driver.findElement(clickReceiveSpecialOffers).click();
        return this;
    }

    @Step
    public RegisterPage insertBirthDate1(String day){
        select  = new Select(driver.findElement(fillDateOfBirth1));
        select.selectByVisibleText(day);
        return this;
    }

    @Step
    public RegisterPage insertBirthDate2(String month){
        select = new Select(driver.findElement(fillDateOfBirth2));
        select.selectByVisibleText(month);
        return this;
    }

    @Step
    public RegisterPage insertBirthDate3(String year){

        select = new Select(driver.findElement(fillDateOfBirth3));
        select.selectByVisibleText(year);
        return this;
    }

    @Step
    public RegisterPage insertFirstNameAddress(String firstNameAddress1){
        driver.findElement(firstNameAddress).sendKeys(firstNameAddress1);
        return this;
    }

    @Step
    public RegisterPage insertLastNameAddress(String lastNameAddress1){
        driver.findElement(lastNameAddress).sendKeys(lastNameAddress1);
        return this;
    }

    @Step
    public RegisterPage insertCompanyNameAddress(String companyNameAddress1){
        driver.findElement(companyAddress).sendKeys(companyNameAddress1);
        return this;
    }

    @Step
    public RegisterPage insertAddressName1(String addressName1){
        driver.findElement(AddressName1).sendKeys(addressName1);
        return this;
    }

    @Step
    public RegisterPage insertAddressName2(String addressName2){
        driver.findElement(AddressName2).sendKeys(addressName2);
        return this;
    }

    @Step
    public RegisterPage insertCountryAddress(String countryAddress){
        select  = new Select(driver.findElement(countryName));
        select.selectByVisibleText(countryAddress);
        return this;
    }

    @Step
    public RegisterPage insertState(String stateName1){
        driver.findElement(stateName).sendKeys(stateName1);
        return this;
    }

    @Step
    public RegisterPage insertCity(String cityName1){
        driver.findElement(cityName).sendKeys(cityName1);
        return this;
    }

    @Step
    public RegisterPage insertZipCode(String zipCodeName1){
        driver.findElement(zipcodeName).sendKeys(zipCodeName1);
        return this;
    }

    @Step
    public RegisterPage insertMobileNumber(String mobileNum1){
        driver.findElement(mobileNumber1).sendKeys(mobileNum1);
        return this;
    }

    @Step
    public RegisterPage clickOnCreateAccountBtn(){
        driver.findElement(createAccountBtn).click();
        return this;
    }

    @Step
    public String accountCreatedTxtVisible(){
        return driver.findElement(accountCreatedText).getText();
    }

    @Step
    public RegisterPage clickOnContinueBtn(){
        driver.findElement(continueBtn).click();
        return this;
    }

    @Step
    public String loggedInUserNameTxtVisible(){
        return driver.findElement(loggedInUserName).getText();
    }

    @Step
    public RegisterPage clickOnDeleteAccount(){
        driver.findElement(deleteAccountBtn).click();
        return this;
    }

    @Step
    public String accountDeletedTxtVisible(){
        return driver.findElement(accountDeletedText).getText();
    }

    @Step
    public RegisterPage clickOnContinueDeleteBtn(){
        driver.findElement(continueDeleteBtn).click();
        return this;
    }
}