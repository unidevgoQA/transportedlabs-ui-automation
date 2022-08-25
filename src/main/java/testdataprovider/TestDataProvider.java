/***
 * TestDataProvider works as intermediate media to access external test data source.
 * <p>
 *  @use {@link #getCredentials(object[][])} method to read data and store in two dimensional array object.
 *  </p>
 */

package main.java.testdataprovider;

import applicationsettings.ApplicationSettings;
import helper.DataReader;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestDataProvider {

    /***
     * Implementing get credentials data functionality
     * @return
     */
    @DataProvider(name = "credentials")
    public static Object[][] getCredentials(Method method){
    	String FileName;
    	if(ApplicationSettings.getEnvironmentType().equalsIgnoreCase("dev")) {
    		FileName = ApplicationSettings.getDevTestDataFilePath();
        }
        else {
        	FileName = ApplicationSettings.getProductionTestDataFilePath();
        }
    	String WorkSheet = ApplicationSettings.getLoginCredentialsSheetName();
    	String TableName = main.java.testdataprovider.TestDataGroup.checkForCredentials(method.getName());
    	
    	return DataReader.getDataFromStorage(FileName, WorkSheet, TableName);
    }




}
