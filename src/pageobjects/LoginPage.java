package pageobjects;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;


public class LoginPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    //Srart: Login page title
    @FindBy(xpath = "//button[@type='button']")
    WebElement loginButton;

    @FindBy(xpath = "//h5[normalize-space()='Configurations']")
    WebElement congratulationsText;

    // Start: Login page elements
    @FindBy(xpath = "//button[text()='Login']")
    WebElement logintext;

    @FindBy(xpath = "//input[@type='text']")
    WebElement idField;

    @FindBy(xpath = "//span[contains(.,'Please enter your email')]")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[normalize-space()='Please enter your password']")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButtonOnLoginPage;

    @FindBy(xpath = "//span[contains(.,'Invalid email')]")
    WebElement invalidEmailErrorMessage;

    // END: Login page elements


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkLoginPageLoaded() {
        try {
            int step = 0;

            driverActions.clearSession();
            driver.get(ApplicationSettings.getUrl());
            Assert.assertTrue(driverWaits.waitUntilVisible(50,loginButton), "Login button not visible");
            step++;
            System.out.println("Step " + step + ": Login button visible");

            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driverWaits.waitUntilVisible(50, logintext);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        public boolean login(String email, String password) {
        System.out.println("Login with email: " + email + " and password: " + password);
        try {
            int step = 0;


            driverActions.typeText(idField, email);
            step++;
            System.out.println("Step " + step + ": Enter email");

            driverActions.typeText(passwordField, password);
            step++;
            System.out.println("Step " + step + ": Enter password");

            driverActions.clickOnWebElementWithActionsClass(loginButton);
            step++;
            System.out.println("Step " + step + ": Click on login button");

            return driverWaits.waitUntilVisible(50, congratulationsText);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}