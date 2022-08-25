package pageobjects;

import applicationsettings.ApplicationSettings;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;


public class GlobalPrizingPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;

    //Srart: Login page title
    @FindBy(xpath = "//button[@type='button']")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Global Prizing')]")
    WebElement globalPrizingPage;

    @FindBy(xpath = "//button[contains(text(),'Add New Prize')]")
    WebElement addNewPrizeBtl;

    @FindBy(xpath = "  //input[@id='mui-91']")
    WebElement PrizeNameInputField;

    @FindBy(xpath = "//div[contains(text(),'AR Drop')]")
    WebElement ARDropDropDownManu;

    @FindBy(xpath = "//div[@type='image']")
    WebElement imagePath;








    // END: Login page elements


    public GlobalPrizingPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean checkGlobalPrizingPageLoaded() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(globalPrizingPage);
            Assert.assertTrue(driverWaits.waitUntilVisible(50,addNewPrizeBtl), "Global Prizing Page is not visible");
            step++;
            System.out.println("Step " + step + ": Global Prizing page is visible");


            return driverWaits.waitUntilVisible(50, addNewPrizeBtl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAddNewPrize() {
        try {
            int step = 0;



            driverActions.clickOnWebElementWithActionsClass(addNewPrizeBtl);
            step++;
            System.out.println("Step " + step + ": Add New Prize section is visible");

            driverActions.typeText(PrizeNameInputField, "Demo Text" );
            step++;
            System.out.println("Step " + step + ": Input Prize Name");

            driverActions.clickOnWebElementWithActionsClass(ARDropDropDownManu);

            step++;
            System.out.println("Step " + step + ": Select dropdown manu airdrop");


            driverActions.uploadImage(imagePath, "banner.png");


            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





}