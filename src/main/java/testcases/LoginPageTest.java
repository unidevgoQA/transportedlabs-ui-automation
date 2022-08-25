package main.java.testcases;

import main.java.testdataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pages.PagesFactory;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 0)
    public void testLoginPageLoaded() {
        try {
            initializeTest("test login page loaded", "Login page loaded",
                    "Integration Testing");

            System.out.println("Checking if login page loaded");

            loginPage = PagesFactory.getLoginPage();
            boolean result = loginPage.checkLoginPageLoaded();
            Assert.assertTrue(result, "Login page not loaded");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }


    @Test(dataProvider = "credentials", dataProviderClass = TestDataProvider.class, priority = 5)
    public void validateLoginFunctionality(String email, String password) {

        try {

            initializeTest("Validate Login Functionality", "This test will verify that user" +
                    " is able to login to the application with valid credential", "Integration Testing");

            loginPage = PagesFactory.getLoginPage();

            System.out.println("\nStarting login into the site.\\n");
            boolean loginResult = loginPage.login(email, password); // true/false
            Assert.assertTrue(loginResult, "Login failed");

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }



}
