
package applicationsettings;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationSettings {

    public static int OTPExpiryTime;
    private static String fileExt;
    private static String browserName;
    private static String url;
    private static String imageFolderPath;
    private static String startTime = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());

    private static String emailAddress;
    private static String activationMessage;
    private static String environmentType;


	// Environment Details for Production
    private static final String productionUrl = "";
    private static final String devUrl = "https://garrett.testingdxp.com/games/air-drop/admin/#/sign-in";
    public static final String profileUrl = "https://garrett.testingdxp.com/games/air-drop/admin/#/sign-in";
    private static final String productionTestDataFilePath = ".//src//testdata//production_test_data.xls";
    private static final String devTestDataFilePath = ".//src//testdata//dev_test_data.xls";

    public static String videoFolderPath = "src/testdata/videos/";

    public static int sessionExpiryTime = 10;

    private ApplicationSettings () { // private constructor
    }

    public static void setUp(String os, String browser, String environment) {

        if(os != null && os.equalsIgnoreCase("Win"))
            fileExt = ".exe";
        else
            fileExt = "";

        if(browser == null)
            browserName = "Chrome";
        else
            browserName = browser;

        if(environment.equalsIgnoreCase("Production")) {
            url = productionUrl;
            environmentType = "prod";
        }
        else if(environment.equalsIgnoreCase("Dev")) {
            url = devUrl;
            environmentType = "dev";
        }
    }

    public static String getBrowserName() {
        return browserName;
    }

    public static String getUrl() {
        return devUrl;
    }

    public static String getEnvironmentType() {
        return environmentType;
    }

    public static String getChromeDriverName() {
        return "webdriver.chrome.driver";
    }

    public static String getChromeDriverPath() {
        return ".//src//lib//chromedriver" + fileExt;
    }

    public static String getIEDriverName() {
        return "webdriver.ie.driver";
    }

    public static String getIEDriverPath() {
        return ".//lib//IEDriverServer" + fileExt;
    }

    public static String getFirefoxDriverName() {
        return "webdriver.gecko.driver";
    }

    public static String getFirefoxDriverPath() {
        return ".//lib//geckodriver" + fileExt;
    }

    public static String getEdgeDriverName() {
        return "webdriver.edge.driver";
    }

    public static String getEdgeDriverPath() {
        return ".//lib//MicrosoftWebDriver" + fileExt;
    }

    public static String getProductionTestDataFilePath(){
        return productionTestDataFilePath;
    }

    public static String getDevTestDataFilePath(){
        return devTestDataFilePath;
    }

    public static String getLoginCredentialsSheetName(){
        return "login";
    }

    public static String getAdminLoginCredentialsSheetName(){
        return "adminCredentials";
    }

    public static String getLoginCredentialsTableName(){
        return "credentials";
    }


    public static String getCurrentDate(){
        return new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.MS").format(new Date());
    }

    public static String getReportGenerationPath(){
        return System.getProperty("user.dir") +"/test-output/Report_" + ApplicationSettings.getSuiteExecutionStartTime() + "/test-report-" + ApplicationSettings.getCurrentDate() + ".html";
    }

    public static String getExtentConfigPath(){
        return System.getProperty("user.dir")+"\\extent-config.xml";
    }

    // Get Drag nad drop js file
    public static String getDragAndDropJsFile() {
        return "src//helper//DragAndDrop.js";
    }

	public static String getImageFolderPath() {
		return imageFolderPath;
	}

    public static String getVideoFolderPath() {
        return videoFolderPath;
    }

    public static void setSessionExpiryTime(int sessionExpiryTime) {
        ApplicationSettings.sessionExpiryTime = sessionExpiryTime;
    }



	public static void setImageFolderPath(String imageFolderPath) {
		ApplicationSettings.imageFolderPath = imageFolderPath;
	}

	public final static String getSuiteExecutionStartTime(){
        return startTime;
    }

	public static String getSignUpDataTableName() {
		return "signUp";
	}

	public static String getAliasEmailAddress(String email){

		String aliasEmailAddress = email + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "@gmail.com";

		emailAddress = aliasEmailAddress;

		return aliasEmailAddress;
    }

	public static String getUpdatedActivationMessage(String firstName, String message){

		String updatedMessage = "Hello " + firstName + message;

		activationMessage = updatedMessage;

		return updatedMessage;
    }

    public static void setOTPExpiryTime(int i) {
        ApplicationSettings.OTPExpiryTime = i;
    }
}
