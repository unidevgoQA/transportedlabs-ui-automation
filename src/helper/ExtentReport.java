/***
 * Extent report class to initialize, update and generate test report
 */

package helper;

import applicationsettings.ApplicationSettings;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public final class ExtentReport {

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    private static long startTime;

    // private constructor to restrict the initialization of this class
    private ExtentReport(){
    	
    }

    /***
     * Implementing set test start time functionality
     */
    public static void setTestStartTime(){
        // TO Do: this method is not tested
        startTime = System.currentTimeMillis();
    }

    /***
     * Implementing initialize test functionality.
     * @param testName
     * @param testDescription
     * @param testCategory
     */
    public static void initializeTest(String testName, String testDescription, String testCategory){
        extentTest = extentReports.startTest(testName);
        extentTest.assignCategory(testCategory);
        extentTest.setDescription(testDescription);
        
    }

    /***
     * Implementing initialize extent report functionality
     */
    public static void initializeExtentReport(){
        String reportPath = ApplicationSettings.getReportGenerationPath();
        String extentConfigPath  = ApplicationSettings.getExtentConfigPath();
        extentReports = new ExtentReports(reportPath, false);
        extentReports.loadConfig(new File(extentConfigPath));

    }

    /***
     * Implementing initialize extent report functionality
     */
    public static void updateTestStatus(ITestResult result) throws IOException {
        try {
    	@SuppressWarnings("unused")
		double executionTime = (System.currentTimeMillis() - startTime) / 1000.0;
    	
    	
    	
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, result.getName() + ": FAILED");
            extentTest.log(LogStatus.FAIL, "EXCEPTION DETAILS : " + result.getThrowable());
            extentTest.log(LogStatus.INFO, "Execution Time : " + executionTime);
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(Screenshots.takeScreenshot(result.getName())));
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, result.getName() + " : SKIPPED");
            extentTest.log(LogStatus.INFO, "Execution Time : " + executionTime);
        }
        else if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, result.getName() + ": PASSED");
            extentTest.log(LogStatus.INFO, "Execution Time : " + executionTime);
            extentTest.log(LogStatus.INFO, "Execution Time : " + executionTime, extentTest.addScreenCapture(Screenshots.takeScreenshot(result.getName())));
        }
//        endTest(logger) : It ends the current test and prepares to create HTML report
        extentReports.endTest(extentTest);
        }
        catch (Exception ex) {
        	System.out.println(ex);
        }

    }


    /***
     * Implementing extent report functionality to generate custom report
     */
    public static void generateReport(){
        extentReports.flush();
        extentReports.close();

    }

}
