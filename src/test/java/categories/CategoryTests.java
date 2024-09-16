package categories;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductsPage;
import pages.HomePage;

public class CategoryTests extends BaseTests {
    @Test
    public void testViewCategoryProducts()
    {
        Assert.assertTrue(homePage.categoryIsVisible(), "Category is not visible");
        homePage.clickOnCategoryWoman();
        CategoryProductsPage categoryProductsPage=homePage.clickOnWomenSubCategory();
        Assert.assertEquals( categoryProductsPage.verifyCategoryHeader(),"WOMEN -  TOPS PRODUCTS");
         categoryProductsPage.clickOnMenCategory();
        categoryProductsPage.clickOnMenSubCategory();
        Assert.assertEquals(categoryProductsPage.verifyCategoryHeader(), "MEN - TSHIRTS PRODUCTS");

    }
}
