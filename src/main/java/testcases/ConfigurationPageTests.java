package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ConfigurationPage;
import pages.PagesFactory;

public class ConfigurationPageTests extends BaseTest {

    ConfigurationPage configurationPage;

    @Test (priority = 0)
    public void testNewConfigurationCreate() {
        try {
            initializeTest("Create new configuration", "This test verifies that a new configuration can be created",
                    "Integration Testing");

            System.out.println("Checking if user can create a new configuration");

            configurationPage = PagesFactory.getConfigurationPage();
            boolean result = configurationPage.createNewConfig();
            Assert.assertTrue(result, "New configuration not created");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }


    @Test (priority = 1)
    public void testGameStart() {
        try {
            initializeTest("Game Start", "This test verifies that game start successfully",
                    "Integration Testing");

            System.out.println("Checking if user can start a game successfully");

            configurationPage = PagesFactory.getConfigurationPage();
            boolean result = configurationPage.startGame();
            Assert.assertTrue(result, "Game not start");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }
    @Test (priority = 2)
    public void testViewGameOnMobile() {
        try {
            initializeTest("Game Start", "This test verifies that game start successfully",
                    "Integration Testing");

            System.out.println("Checking if user can start a game successfully");

            configurationPage = PagesFactory.getConfigurationPage();
            boolean result = configurationPage.viewGameOnMobile();
            Assert.assertTrue(result, "Game not open");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

    @Test (priority = 3)
    public void testDeleteConfiguration() {
        try {
            initializeTest("Delete configuration", "This test verifies that a configuration delete successfully",
                    "Integration Testing");

            System.out.println("Checking if user can delete a configuration");

            configurationPage = PagesFactory.getConfigurationPage();
            boolean result = configurationPage.deleteConfig();
            Assert.assertTrue(result, "New configuration not not delete");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }

    }

}

