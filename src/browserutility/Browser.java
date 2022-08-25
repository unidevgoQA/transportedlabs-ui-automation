
package browserutility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

//
//import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//
import applicationsettings.ApplicationSettings;

import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;

public final class Browser {

    private Browser() {
        //private constructor to prevent initializing the browser object.
    }

    private static WebDriver webDriver;

    public static WebDriverWait getWait() {
        return getWait(30);
    }

    public static WebDriverWait getWait(int wait) {
        return new WebDriverWait(webDriver, wait);
    }

    /***
     * Implementing launch browser functionality
     */
    public static void launchBrowser() {
        String browser = ApplicationSettings.getBrowserName();
        try {
            if (browser.equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();

            } else if (browser.equalsIgnoreCase("Chrome")) {
                Map<String, Object> preferences = new Hashtable<String, Object>();
                preferences.put("profile.default_content_settings.popups", 0);

//                // disable flash and the PDF viewer
                preferences.put("plugins.plugins_disabled", new String[]{
                        "Adobe Flash Player", "Chrome PDF Viewer"});

                LoggingPreferences loggingprefs = new LoggingPreferences();
                loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);

//                ChromeDriverService service = ChromeDriverService.createDefaultService();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", preferences);
                options.addArguments("--test-type");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-notifications");
                options.addArguments("chrome.switches", "--disable-extensions");
                options.addArguments("disable-infobars");
                options.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);

                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            webDriver.manage().window().maximize();
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }

    /***
     * Implementing get webdriver functionality
     * @return
     */
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    /***
     * Implementing goToUrl functionality
     * @param url
     */
    public static void goToUrl(String url) {
        webDriver.get(url);
    }

    /***
     * Implementing closeFocusedScreen functionality
     */
    public static void closeFocusedScreen() {
        webDriver.close();
    }

    /***
     * Implementing quitBrowser functionality
     */
    public static void quitBrowser() {
        webDriver.quit();
    }

    public static void AcceptAlert() {

        Alert alert = Browser.getWebDriver().switchTo().alert();
        alert.accept();
        getWebDriver().switchTo().defaultContent();

    }
}
