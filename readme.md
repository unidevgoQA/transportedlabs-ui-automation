## Overview
BenchWorks is a consultant management system
# Integration Testing of Benchworks

+ Java
+ Selenium Web Driver
+ TestNG

Project will be build using *Maven* as software project management tool, with surefire plugin, which will help in future with integration in continuous integration tools like Jenkins. The goal for this project is to create complete framework which could be used in real implementations.



## Execution of Benchworks tests
`mvn clean test`

## Test HTML report location
`/test-output/` - Look for the latest date after running tests inside this directory

#### Browsers
Project has been implemented to work with serveral browser set up by <browser> parameter in paramterers.xml. Available browsers:
+ Chrome
+ Firefox
+ IE

# Project Structure
- `src/ApplicationSettings` - contains all the application settings
- `src/browserUtility` - contains all the browser utility methods
- `src/DataModel` - contains all the data model classes which cleanses data
- `src/helper` - contains all the helper methods
- `src/main/java/testcases` - contains all the test cases
- `src/pageobjects` - contains all the page objects
- `src/testdata` - contains all the static data and methods to generate dynamic data as per the requirement
- `src/testdata/testdata.xlsx` - contains all the static data
- `src/test.benchworks/TESTNG.XML` - contains all the testng.xml file
- `/test-output` - contains test reports

# Test Coverage
- `Registration Page` - 100%
- `Login Page` - 100%
- `Home Page` - 100%
- `Dashboard Page` - 100%
- `Project Page` - 60%
- `Product Page` - 60%
- `Skill Page` - 60%
- `Team page` - 60%
- `Technical Manager Page` - 60%
- `Profile page`
- `OS Page` - 60%
- `Manage Request Page` - 60%