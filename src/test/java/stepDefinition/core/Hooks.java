package stepDefinition.core;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.LogDetail;
import org.apache.log4j.Logger;
import utils.ActionsUtil;
import utils.ScreenshotUtil;

public class Hooks extends ActionsUtil {
    private static Logger log = Logger.getLogger(Hooks.class);

    /**
     * This method is executed before each scenario to log that the
     * scenario is started using its name inside the logs.txt file and
     * add a new entry for the test case to be executed inside the
     * html report  using its name
     *
     * @param scenario the scenario to be executed
     */
    @Before(order = 0)
    public void before(Scenario scenario) {
        var scenarioName = scenario.getName();

        log.info("---------------------------------------------------------------");
        log.info(String.format("Test Case Name: %s", scenarioName));
        log.info("Status: Started");
        log.info("---------------------------------------------------------------");

        test = report.startTest(scenarioName);
    }

    /**
     * This method is used to initialize the browser instance before
     * any flow scenario
     *
     * @throws Exception in case of not being able to initialize the
     *                   browser instance with the desired data
     */
    @Before(value = "@flow", order = 1)
    public void beforeFlow() throws Exception {
        initializeBrowser();
    }

    /**
     * This method is used to initialize the configurations of
     * the Rest Assured before any restful api scenario
     */
    @Before(value = "@rest", order = 1)
    public void beforeRest() {
        HttpClientConfig httpConfig = new HttpClientConfig();

        RestAssured.reset();
        RestAssured.config = RestAssured.config().httpClient(httpConfig);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    /**
     * This method is executed after each scenario to log the final
     * results of the executed scenario inside both the log file or
     * the html report, take a screenshot in case of the test case has
     * failed and save it to the html report
     *
     * @param scenario the executed scenario
     * @throws Exception in case of not being able to log the final
     *                   results of the executed scenario in both the log
     *                   file and the html report or not being able to
     *                   take a screenshot in case of having failed test
     *                   case
     */
    @After(order = 1)
    public void after(Scenario scenario) throws Exception {
        logTestRunResults(scenario);
    }

    /**
     * This method is used to close the opened browser instance
     * after any flow scenario
     */
    @After(value = "@flow", order = 0)
    public void afterFlow() {
        closeDriver();
    }

    /**
     * This method is executed after each scenario to log the final
     * results of the executed scenario inside both the log file and the
     * html report also to take a screenshot in case of the scenario
     * has failed and save it to the html report
     *
     * @param scenario the executed scenario
     * @throws Exception in case of not being able to log the final
     *                   results of the executed scenario in either the
     *                   log file or the html report or not being able
     *                   to take a screenshot in case of having failed
     *                   scenario
     */
    private void logTestRunResults(Scenario scenario) throws Exception {
        var scenarioStatus = scenario.getStatus();
        var scenarioName = scenario.getName();

        switch (scenarioStatus) {
            case PASSED:
                logSuccess(String.format("Test Status: %s", "Passed"));
                break;
            case FAILED:
                if (driver != null) {
                    var screenshotsPath = properties.getProperty("screenshotsPath");

                    test.log(LogStatus.ERROR, "Check the following screenshot: "
                            + test.addBase64ScreenShot("data:image/png;charset=utf-8;base64, " +
                            ScreenshotUtil.takeScreenshot(driver
                                    , screenshotsPath
                                    , "Screenshot_" + scenarioName + ".png")));
                }

                logFail(String.format("Test Status: %s", "Failed"));
                break;
            case SKIPPED:
                logSkip(String.format("Test Status: %s", "Skipped"));
                break;
            default:
                logUnknown(String.format("Test Status: %s", "Unknown"));
                break;
        }
    }
}
