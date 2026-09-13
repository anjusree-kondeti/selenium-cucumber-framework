package com.yourcompany.automation.hooks;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.reporting.ExtentReportManager;
import com.yourcompany.automation.runners.TestRunner;

public class Hooks {

    // ============================================================
    // BEFORE SCENARIO
    // ============================================================

    @Before
    public void beforeScenario(Scenario scenario) {

        // --------------------------------------------------------
        // 1. Get scenario name
        // --------------------------------------------------------

        String scenarioName = scenario.getName();


        // --------------------------------------------------------
        // 2. Create ExtentTest for this scenario
        // --------------------------------------------------------

        ExtentReportManager.createTest(scenarioName);

        ExtentReportManager.info(
                "Scenario execution started");

        ExtentReportManager.info(
                "Scenario: " + scenarioName);


        // --------------------------------------------------------
        // 3. Initialize Browser
        // --------------------------------------------------------
            String browser = "chrome";
        DriverFactory.initDriver(browser);

        ExtentReportManager.info(
                "Browser initialized successfully");
    }



    // ============================================================
    // AFTER SCENARIO
    // ============================================================

    @After
    public void afterScenario(Scenario scenario) {

        // --------------------------------------------------------
        // 1. Check Scenario Status
        // --------------------------------------------------------

        if (scenario.isFailed()) {

            ExtentReportManager.fail(
                    "Scenario Failed");

            ExtentReportManager.info(
                    "Scenario Status: FAILED");


            // ----------------------------------------------------
            // 2. Take Screenshot
            // ----------------------------------------------------

            if (DriverFactory.getDriver() != null) {

                try {

                    byte[] screenshot =
                            ((TakesScreenshot)
                                    DriverFactory.getDriver())
                                    .getScreenshotAs(
                                            OutputType.BYTES);


                    // Attach screenshot to Cucumber
                    scenario.attach(
                            screenshot,
                            "image/png",
                            "Failure Screenshot");


                    // Attach screenshot to Extent Report
                    String base64Screenshot =
                            java.util.Base64
                                    .getEncoder()
                                    .encodeToString(
                                            screenshot);

                    ExtentReportManager.getTest()
                            .fail(
                                    "Failure Screenshot",
                                    MediaEntityBuilder
                                            .createScreenCaptureFromBase64String(
                                                    base64Screenshot)
                                            .build()
                            );

                } catch (Exception e) {

                    ExtentReportManager.info(
                            "Unable to capture screenshot: "
                                    + e.getMessage());
                }
            }

        } else {

            ExtentReportManager.pass(
                    "Scenario Passed");

            ExtentReportManager.info(
                    "Scenario Status: PASSED");
        }
        
     // --------------------------------------------------------
        // 3. Quit Browser
        // --------------------------------------------------------

        DriverFactory.quitDriver();

        ExtentReportManager.info(
                "Browser closed successfully");


        // --------------------------------------------------------
        // 4. Flush Extent Report
        // --------------------------------------------------------

        ExtentReportManager.flush();


        // --------------------------------------------------------
        // 5. Remove ThreadLocal ExtentTest
        // --------------------------------------------------------

        ExtentReportManager.removeTest();
    }
}