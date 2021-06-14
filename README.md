# vodafone
vodafone is a Java testing framework built with BDD concept using cucumber to cover both the flows or restful APIs scenarios.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for testing purposes.

## Concepts Included
* Testing Framework design
* Page Object pattern
* Page 
* BDD
* Cucumber
* JUnit
* RestAssured
* Gherkin Language
* Common web page interaction methods
* Extracting test data from json file
* Html reports for testing outputs
* Screenshots for the testing outputs

## Tools
* Maven
* Selenium WebDriver
* Cucumber
* JUnit
* RestAssured

## Requirements
In order to utilize this project, you need to have the following installed locally:
* Maven
* Chrome version 90.0.4430.212
* Java Compiler 11
* Cucumber

## Installing
* Install Java
* Set the System Environment variables with JDK and JRE paths
* Install Eclipse or IntelliJ
* Install Cucumber inside the IDE if not configured by default
* Install Maven inside the IDE if not configured by default
* Install Git
* Clone the project from `https://github.com/amrhusseinsayed/vodafone.git`

## Framework structure
* `flows.feature` in the directory `src/test/resources/feature` holds the steps of the scenarios related to the Login, Registration and Checkout modules
* `api.feature` in the directory `src/test/resources/feature` holds the steps of the scenarios related to the Posts collection APIs
* `TestRunner.java` in the directory `src/test/java/runner` holds the one method to run before all the scenarios and another method to run after all the scenarios
* `Hooks.java` in the directory `src/test/java/stepDefinition/core` holds the hooks that will be executed either after or before each scenario
* `PostsDef.java` in the directory `src/test/java/stepDefinition/api` holds the methods of the steps related to the `Posts` module APIs collection
* `HomepageDef.java` in the directory `src/test/java/stepDefinition/ui` holds the methods of the steps related to the 'Homepage'
* `MyAccountDef.java` in the directory `src/test/java/stepDefinition/ui` holds the methods of the steps related to the `My Account` module
* `CreateAccountDef.java` in the directory `src/test/java/stepDefinition/ui` holds the methods of the steps related to the `Registration` module
* `ItemsDef.java` in the directory `src/test/java/stepDefinition/ui` holds the methods of the steps related to the `Items` module
* `CheckoutDef.java` in the directory `src/test/java/stepDefinition/ui` holds the methods of the steps related to the `Checkout` module
* `PostsImpl.java` in the directory `src/test/java/stepDefinitionImplementation/api` holds the implementation of the methods linked with the steps related to the `Posts` module APIs collection
* `HomepageImpl.java` in the directory `src/test/java/stepDefinitionImplementation/ui` holds the implementation of the methods linked with the steps related to the 'Homepage`
* `MyAccountImpl.java` in the directory `src/test/java/stepDefinitionImplementation/ui` holds the implementation of the methods linked with the steps related to the 'My Account` module
* `CreateAccountImpl.java` in the directory `src/test/java/stepDefinitionImplementation/ui` holds the implementation of the methods linked with the steps related to the 'Registration` module
* `ItemsImpl.java` in the directory `src/test/java/stepDefinitionImplementation/ui` holds the implementation of the methods linked with the steps related to the 'Items` module
* `CheckoutImpl.java` in the directory `src/test/java/stepDefinitionImplementation/ui` holds the implementation of the methods linked with the steps related to the 'Checkout` module
* `ActionsUtil.java` in the directory `src/test/java/utils` holds the helper methods that can be used during the execution
* `ExtentReportUtil.java` in the directory `src/test/java/utils` holds the methods used to initialize the Html report that will be used to collect the executions results
* `JsonFileUtil.java` in the directory `src/test/java/utils` holds the methods of handling the json files
* `Log4jUtil.java` in the directory `src/test/java/utils` holds a method to load the configurations of the logs file
* `PropertiesFileUtil.java` in the directory `src/test/java/utils` holds a method to read any properties file
* `ScreenshotUtil.java` in the directory `src/test/java/utils` holds a method to take a screenshot from the current view
* `data.json` in the directory `src/test/resources/testData` is the test data used during the execution
* `config.properties` in the directory `src/test/resources/configurations` holds the properties that will be used during the execution
* `log4j.xml` in the directory `src/test/resources/configurations` holds the configurations of the logger that will be used during the execution
* `extent-config.xml` in the directory `src/test/resources/configurations` holds the configurations of the html report that will hold all the results of the executed scenarios
* `chromedriver.exe` in the directory `src/test/resources/drivers` is the WebDriver used during the execution
* `src/test/java/testOutputs` will hold the html report with the status of the executed scenarios also a folder for the screenshots taken during the execution

## Running the tests
* Navigate to `src/test/resources/testData` directory and open `data.json` file
* Set the data of the users as required and make sure the `user1` has an email address that has not been registered before
* You can run all the scenarios either by building the project as Maven project and all the scenarios will be automatically executed after the compilation process or you can run the `TestRunner.java` as a JUnit class
* In case you want to run specific scenario(s), you will have to set its tag in the `TestRunner.java`

## Running workflow description
* The execution begins from the method under the annotation `@BeforeClass` inside `TestRunner.java` and it does the following
  * Extract the properties from the `config.properties` that will be used during the execution
  * Extract the test data from `data.json` that will be used during the execution
  * Initialize the HTML Extent Report using its `extent-config.xml` file
  * Initialize the Logger using its `log4j.xml` file
* The method under the annotation `@Before(order = 0)` inside `Hooks.java` is called to add an entry for the scenario to be executed inside the html report
* If the scenario to be executed has the `@flow` annotation inside its feature file, then the method under the annotation `@Before(value = "@flow", order = 1)` inside `Hooks.java` is called to initialize a browser instance based on the extracted properties
* If the scenario to be executed has the `@api` annotation inside its feature file, then the method under the annotation `@Before(value = "@api", order = 1) inside `Hooks.java` is called to initialize the Rest Assured configurations
* Then the first scenario is executed and each executed step is logged inside both the html report and the log file
* After executing all the scenario steps, the method under the annotation `@After(order = 1)` inside `Hooks.java` is called to log the final results of the scenario inside both the log file and the html report also to take screenshot if the scenario fails
* If the executed scenario has the `@flow` annotation inside its feature file, then the method under the annotation `@After(value = "@flow", order = 0)` inside `Hooks.java` is called to close the running browser instance
* If the execution contains more than one scenario, they will be executed sequentially based on their order
* Finally, the method under the annotation `@AfterClass` inside `TestRunner.java` is called to flush the data of the executed scenario(s) inside the html report

## Reporting
You can see a sample of the testing report, logs files and screenshots in the directory `src/test/resources/testOutputs` which contains
* `screenshots folder which contains a screenshot for a failed scenario that has a name matches the failed scenario name
* `html-report-all-scenarios-passed.html` an html report that has all the scenarios passed
* `html-report-with-failed-scenario.html` an html report that has all the scenarios passed except one failed scenario
* `logfile-with-all-scenarios-passed.log` logs file that has all the scenarios passed
* `logfile-with-failed-scenario.log` logs file that has all the scenarios passed except one failed scenario

## Notes
* Make sure that the Java Complier used during the run is 11 or higher
* In case you face any compiler errors, make sure that the `Language Level` and the `Target bytecode version` of the project are set to `11` 
* The `ActionsUtil.java` class contains only the helper methods that were called during with the flows or the APIs scenarios but it can be modified anytime to have more helper methods
* All the scenarios to be executed should not have the tag `@ignore`
* You can replace the `chromedriver.exe` with the one that matches your browser version
