/**
 * Driver Command class implementation.
 * Author: Jony, Date: September 12, 2018
 */

package browserutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverCommand {

    final WebDriver webDriver;

    public DriverCommand(){

        this.webDriver = Browser.getWebDriver();
    }

    /***
     * Implementing Webdriverwait functionality
     * @return Webdrierwait
     */
    public WebDriverWait explicitlyWait(){
        return explicitlyWait(30);
    }

    /***
     * Implementing overload of Webdriverwait functionality
     * @param wait: Take the timeout value as integer
     * @return
     */
    public WebDriverWait explicitlyWait(int wait){

        return new WebDriverWait(webDriver, wait);
    }

    /***
     * Implementing implicitWait functionality. This function has been implemented to avoid Thread.sleep()
     * @param waitTimeOut
     */
    public void implicitWait(int waitTimeOut){
        try{
            explicitlyWait(waitTimeOut).until(ExpectedConditions.presenceOfElementLocated(By.id("dummy locator")));
        }catch (Exception exception){

        }

    }

    /***
     * Implementing maximizeWindow functionality
     */
    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    /***
     * Implementing minimizeWindow functionality
     */
    public void minimizeWindow(){
        webDriver.manage().window().maximize();
    }

    /***
     * Implementing close focused screen functionality
     */
    public void closeFocusedScreen(){
        Browser.closeFocusedScreen();
    }

    /***
     * Implementing get current page title functionality
     * @return current page title
     */
    public String getCurrentPageTitle() {
        return webDriver.getTitle();
    }


}
