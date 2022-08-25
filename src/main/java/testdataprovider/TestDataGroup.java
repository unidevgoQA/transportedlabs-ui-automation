package main.java.testdataprovider;

import applicationsettings.ApplicationSettings;

public class TestDataGroup {
	
	public static String checkForCredentials(String group) {
		String tableName = null;
		
		if(group.equalsIgnoreCase("validateLoginFunctionality")) {
    		tableName = ApplicationSettings.getLoginCredentialsTableName();
    	}
		else if(group.equalsIgnoreCase("validateSignUpFunctionality")) {
    		tableName = ApplicationSettings.getSignUpDataTableName();
    	}
		else if(group.equalsIgnoreCase("validateAdminLoginFunctionality"))
			tableName = ApplicationSettings.getAdminLoginCredentialsSheetName();

		return tableName;
	}



}
