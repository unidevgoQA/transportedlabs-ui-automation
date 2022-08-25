/**
 * Base page class implementation.
 * Author: Jony, Date: September 12, 2018
 *
 * This is application specific base page class. Application specific common functionalities belong to base page.
 * All child pages will inherit thi base class.
 */

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserutility.Browser;
import browserutility.DriverCommand;

public class Base {

    DriverCommand driverCommand;

    /***
     * Constructor of Base class. initializing Driver Command class inside constructor.
     */
    public Base(){
        driverCommand = new DriverCommand();

    }

    public void AcceptAlert(){
    	
		Browser.AcceptAlert();
    	
    }
    
    public WebDriver getWebDriver(){
		return Browser.getWebDriver();
    }
    
    /***
     * Implementing Webdriverwait functionality
     * @return Webdrierwait
     */
    public WebDriverWait explicitlyWait(){
        return driverCommand.explicitlyWait(30);
    }

    /***
     * Implementing overload of Webdriverwait functionality
     * @param wait: Take the timeout value as integer
     * @return Webdrierwait
     */
    public WebDriverWait explicitlyWait(int wait){
        return driverCommand.explicitlyWait(wait);
    }

    /***
     * Implementing maximizeWindow functionality
     */

    public void maximizeWindow(){
        driverCommand.maximizeWindow();
    }

    /***
     * Implementing minimizeWindow functionality
     */
    public void minimizeWindow(){
        driverCommand.minimizeWindow();
    }

    /***
     * Implementing implicitWait functionality. This function has been implemented to avoid Thread.sleep()
     * @param waitTimeOut
     */
    public void implicitlyWait(int waitTimeOut){
        driverCommand.implicitWait(waitTimeOut);

    }

    /***
     * Implementing close focused screen functionality
     */
    public void closeFocusedScreen(){
        driverCommand.closeFocusedScreen();
    }

    /***
     * Implementing is expected element visible functionality
     * @param locator
     * @param waitTimeOut
     * @return
     */
    public boolean isExpectedElementVisible(String locator, int waitTimeOut){
        boolean status = true;
        try{
            explicitlyWait(waitTimeOut).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));

        }catch (WebDriverException exception){
            status = false;
        }
        return status;

    }
    
    /***
     * Implementing is expected element visible functionality
     * @param locator
     * @param waitTimeOut
     * @return
     */
    public boolean isExpectedElementVisible(By locator, int waitTimeOut){
        boolean status = true;
        try{
            explicitlyWait(waitTimeOut).until(ExpectedConditions.visibilityOfElementLocated(locator));

        }catch (WebDriverException exception){
            status = false;
        }
        return status;

    }
    
    /***
     * Implementing get current page title functionality
     * @return current page title
     */
    public String getCurrentPageTitle() {
        return driverCommand.getCurrentPageTitle();
    }

}
