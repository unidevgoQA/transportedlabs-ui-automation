
package main.java.testcases;

import applicationsettings.ApplicationSettings;
import browserutility.Browser;
import helper.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class BaseTest {


    /***
     * Implementing suite setup functionality
     */
    @BeforeSuite(alwaysRun = true)
    public void setUp( ) {
        ExtentReport.initializeExtentReport();

        String os = System.getProperty("executionOS");
        String browser = System.getProperty("executionBrowser");
        String environment = System.getProperty("executionEnvironment");
        ApplicationSettings.setUp(os, browser, environment);

        // Comment out below line when running dynamic environments
//        ApplicationSettings.setUp(os, browser, environment);
        System.out.println("Operating System: " + os);
        System.out.println("Browser: " + browser);
        System.out.println("Environment: " + environment);

        Browser.launchBrowser();
        Browser.goToUrl(ApplicationSettings.getUrl());

    }


    /***
     * Implementing before test method functionality
     */
    @BeforeMethod
    public void startTest(){

    	ExtentReport.setTestStartTime();

    }


    /***
     * Implementing extent report functionality to update test status.
     */
    @AfterMethod(alwaysRun = true)
    public void testStatus(ITestResult result) throws IOException {
        ExtentReport.updateTestStatus(result);

    }


    /***
     * Implementing initialize test functionality
     * @param testName Test Case Name
     * @param testDescription Test Case Description
     * @param testCategory Test Case Category
     */
    public void initializeTest(String testName, String testDescription, String testCategory){
        ExtentReport.initializeTest(testName, testDescription, testCategory);
    }

    /***
     *
     * Implementing suite teardown functionality
     */
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Browser.closeFocusedScreen();
    	System.out.println("Starting quitting the browser.");
    	Browser.quitBrowser();
        System.out.println("Quit the browser.");

        System.out.println("Starting Generating the report.");
        ExtentReport.generateReport();
        System.out.println("Generating the report.");
    }

}
