package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvancedSearchTest extends BaseTestRunner {

    @BeforeClass
    public void setUp() {
        setDriver();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void checkAdvancedSearch() {
       HomePage Page = new HomePage(driver);

       boolean check  = Page
               .openAdvancedSearch()
               .isAdvancedSearchOpen();

       Assert.assertTrue(check);

       check = Page
               .openAdvancedSearch()
               .isAdvancedSearchOpen();

       Assert.assertFalse(check);
    }

    @Test
    public void AdvancedSearch() throws InterruptedException {

        String radioValue = new HomePage(driver)
                .openAdvancedSearch()
                .getRadioValueString();

        Assert.assertEquals(radioValue,"Гурток");

        new AdvancedSearchModel(driver).chooseDropDownCity("Львів");

        //Not finished

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}