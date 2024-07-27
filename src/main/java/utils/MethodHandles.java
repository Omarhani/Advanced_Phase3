package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MethodHandles {

    protected WebDriver driver;

    WebDriverWait wait;
    static ExtentReports extent;
    static ExtentTest test;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    private void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)
        ));
    }
    protected void click(By locator, int time){
        explicitWait(locator,time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        webElement(locator).click();
    }
    protected void sendKeys(By locator, int time, String text){
        explicitWait(locator,time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        webElement(locator).sendKeys(text);
    }
    protected String getText(By locator, int time){
        explicitWait(locator,time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        return webElement(locator).getText();
    }

    protected boolean isDisplayed(By locator, int time){
        explicitWait(locator, time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        return webElement(locator).isDisplayed();
    }

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }

    private void setSteps(){
        test.info(getMethodName());
    }
    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '5px solid red';", element);
    }
    public static void myAssertEquals(String actual, String expected){
        test.info(MarkupHelper.createLabel("------------------- Ends of Steps -------------------", ExtentColor.TEAL));

        test.info(MarkupHelper.createLabel("------------------- actual Result -------------------", ExtentColor.TEAL));
        test.info(actual);

        test.info(MarkupHelper.createLabel("------------------- expected Result  -------------------", ExtentColor.TEAL));
        test.info(expected);

        assertEquals(actual,expected);
    }
}
