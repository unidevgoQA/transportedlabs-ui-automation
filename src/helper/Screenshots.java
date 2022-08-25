/***
 * Screenshot is a helper class which helps to capture custom screenshot.
 * <p>
 * @use {@link #takeScreenshot(String)} method to capture screenshot.
 *  </p>
 */
package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import browserutility.Browser;
import applicationsettings.ApplicationSettings;

import java.io.File;
import java.io.IOException;

public final class Screenshots {

    /***
     * Implementing take Screenshot functionality.
     * @param fileName
     * @return screenshot file path
     * @throws IOException
     */
    public static String takeScreenshot(String fileName) throws IOException {

        String date = ApplicationSettings.getCurrentDate();
        TakesScreenshot screenshot = (TakesScreenshot) Browser.getWebDriver();
        File screenshotSource = screenshot.getScreenshotAs(OutputType.FILE);
//        String screenshotFilePath =  System.getProperty("user.dir") + "/test-output/screenshots/" + fileName + "_" + date + ".png";
        String screenshotFilePath =  System.getProperty("user.dir") + "/test-output/Report_" + ApplicationSettings.getSuiteExecutionStartTime() + "/" + fileName + "_" + date + ".png";
        File screenshotDestination = new File(screenshotFilePath);
        FileUtils.copyFile(screenshotSource, screenshotDestination);
        return fileName + "_" + date + ".png";

    }

}
