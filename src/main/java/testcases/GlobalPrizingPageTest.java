package main.java.testcases;

import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GlobalPrizingPage;
import pages.PagesFactory;

public class GlobalPrizingPageTest extends BaseTest {

    GlobalPrizingPage globalPrizingPage;

    @Test(priority = 0)
    public void testGlobalPrizingPageLoaded() {
        try {
            initializeTest("test login page loaded", "Login page loaded",
                    "Integration Testing");

            System.out.println("Checking if login page loaded");

            globalPrizingPage = PagesFactory.getGlobalPrizingPage();
            boolean result = globalPrizingPage.checkGlobalPrizingPageLoaded();
            Assert.assertTrue(result, "Login page not loaded");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }


    }

    @Test(priority = 1)
    public void testAddNewPrize() {
        try {
            initializeTest("test login page loaded", "Login page loaded",
                    "Integration Testing");

            System.out.println("Checking if login page loaded");

            globalPrizingPage = PagesFactory.getGlobalPrizingPage();
            boolean result = globalPrizingPage.checkAddNewPrize();
            Assert.assertTrue(result, "Login page not loaded");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }








}
