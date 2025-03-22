package com.automation.nike.tests;

import com.automation.nike.pages.SearchProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchProductsTest extends BaseTest{

    SearchProductsPage searchProductsPage;

    @Test(dataProvider = "SearchData")
    public void SearchProductsJordanTest(String products, String searchResults1, String searchResults2) throws InterruptedException {
        searchProductsPage = new SearchProductsPage(driver);
        searchProductsPage.searchProducts(products);

        Thread.sleep(5000);

        int product = 1;
        for(String results : searchProductsPage.getSearchResults()){
            Assert.assertTrue(results.contains(searchResults1) || results.contains(searchResults2) , "Product: " + product + " does not contain Jordan");
            product++;
        }

    }

    @DataProvider(name = "SearchData")
    public Object[][] searchData(){
        return new Object [][] {
                {"Jordan", "Jordan", ""},
                {"Dunks", "Dunk", ""},
                {"Air Forces", "Forces", ""},
                {"Backpacks", "Backpack", "Bag"},
                {"Air Max", "Air Max", ""},
                {"Cortez", "Cortez", ""},
        };
    }

}
