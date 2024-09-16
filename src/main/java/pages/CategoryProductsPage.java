package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CategoryProductsPage extends MethodHandles {
    public CategoryProductsPage(WebDriver driver)
    {
        super(driver);
    }

    private final By categoryHeader=By.xpath("//h2[@class='title text-center']");
    private final By menCategory=By.xpath("//a[normalize-space()='Men']");
    private final By menSubCategory=By.xpath("//a[normalize-space()='Tshirts']");

    public String verifyCategoryHeader()
    {
        return getText(categoryHeader,3);
    }
    public void clickOnMenCategory()
    {
        click(menCategory,3);
    }
    public void clickOnMenSubCategory()
    {
        click(menSubCategory,3);
    }
}
