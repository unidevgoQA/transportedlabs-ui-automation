package pageobjects;
import java.util.UUID;
import helper.DriverActions;
import helper.DriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.PagesFactory;


public class ConfigurationPage extends Base {

    private final WebDriver driver;
    private final DriverWaits driverWaits;
    private final DriverActions driverActions;


    @FindBy(xpath = "//h5[contains(text(), 'Configuration')]/following-sibling::button")
    WebElement plusButton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement nameField;

    @FindBy(xpath = "//button[normalize-space()='ADD']")
    WebElement addButton;

    @FindBy(xpath = "(//p[contains(text(),'Delete')])[1]")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement confirmationDeleteBtn;

    @FindBy(xpath = "(//button[contains(text(),'Start')])[1]")
    WebElement startBtn;

    @FindBy(xpath = "(//h1[contains(text(),'START')])[1]")
    WebElement startGameWindow;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement startConfirmationBtn;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement noGamePrizeWarringBtl;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement mobileIcon;

    @FindBy(xpath = "//p[contains(text(),'Mobile Link')]")
    WebElement getMobileLinkWindow;

    @FindBy(xpath = "//a[contains(text(),'Open Link')]")
    WebElement openGameLink;

    @FindBy(xpath = "//h6[contains(text(),'Menu')]")
    WebElement getGameOpenTab;


    @FindBy(xpath = "(//button[contains(text(),'Live')])[1]")
    WebElement liveBtn;







    public ConfigurationPage(WebDriver driver) {
        this.driver = driver;
        this.driverActions = PagesFactory.getDriverActionsObject();
        this.driverWaits = PagesFactory.getDriverWaitsObject();
    }

    public boolean createNewConfig() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(plusButton);
            step++;
            System.out.println(step + ": Clicked '+' button.");

            UUID randomUUID = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

            driverActions.typeText(nameField, "test_" + randomUUID);
            step++;
            System.out.println(step + ": Entered random name");

            driverActions.clickOnWebElementWithActionsClass(addButton);
            step++;
            System.out.println(step + ": Clicked add button");

            String text = randomUUID.toString().substring(0, 8);

            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return driverWaits.waitUntilVisible(50, element);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public boolean deleteConfig() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(deleteBtn);
            step++;
            System.out.println(step + ": Clicked delete button.");

            driverActions.clickOnWebElementWithActionsClass(confirmationDeleteBtn);
            step++;
            System.out.println(step + ": Clicked delete button");

            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public boolean startGame() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(startBtn);

            Assert.assertTrue(driverWaits.waitUntilVisible(50,startGameWindow), "Start window is not showing");

            step++;
            System.out.println(step + ": Clicked start button.");

            driverActions.clickOnWebElementWithActionsClass(startConfirmationBtn);
            step++;
            System.out.println(step + ": Clicked start button");

            driverActions.clickOnWebElementWithActionsClass(noGamePrizeWarringBtl);


            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean viewGameOnMobile() {
        try {
            int step = 0;

            driverActions.clickOnWebElementWithActionsClass(mobileIcon);

            Assert.assertTrue(driverWaits.waitUntilVisible(50,getMobileLinkWindow), "Mobile link window is not showing");

            step++;
            System.out.println(step + ": Clicked mobile icon button.");

            driverActions.clickOnWebElementWithActionsClass(openGameLink);
            step++;
            System.out.println(step + ": Clicked start button");

            String tabTitle = driver.getTitle();
//            driverActions.switchToBrowserTab(tabTitle);



            driver.manage().window().setSize(new Dimension(390, 844));


            Assert.assertTrue(driverWaits.waitUntilVisible(100,getGameOpenTab), "Mobile link new window is not showing");



            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}