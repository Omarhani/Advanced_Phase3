package Products;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ProductsSearch;

import java.io.FileNotFoundException;

public class SearchProductTests extends BaseTests {

    @Test
    public void testSearchProduct() throws FileNotFoundException {

        Assert.assertTrue(homePage.homePageVisible(),"Home page is not visible");


        ProductsPage productsPage1 = homePage.clickProductsLinkLink();
        Assert.assertTrue(productsPage1.productsPageVisible(),"products page is visible");

        productsPage1.insertSearchProductTxt(dataModel().SearchOnProducts.SearchedOnProducts.Product);

        ProductsSearch searchPro =  productsPage1.clickOnSearchBtn();
        Assert.assertEquals(searchPro.getSearchedProductsTxt() , "SEARCHED PRODUCTS");
        Assert.assertTrue(searchPro.getRelatedSearchProduct() , "Tshirt");
    }
}
