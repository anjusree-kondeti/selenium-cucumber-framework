package com.yourcompany.automation.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();


    // ============================================================
    // CREATE / GET EXTENT REPORT
    // ============================================================

    public static synchronized ExtentReports getExtentReports() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            // System information
            extentReports.setSystemInfo(
                    "Project", "Cucumber Automation");

            extentReports.setSystemInfo(
                    "Framework", "Selenium + Java + Cucumber");

            extentReports.setSystemInfo(
                    "Environment", "QA");

            extentReports.setSystemInfo(
                    "Tester", "Automation Team");
        }

        return extentReports;
    }


    // ============================================================
    // CREATE TEST
    // ============================================================

    public static synchronized ExtentTest createTest(
            String testName) {

        ExtentTest test =
                getExtentReports().createTest(testName);

        extentTest.set(test);

        return test;
    }


    // ============================================================
    // GET CURRENT EXTENT TEST
    // ============================================================

    public static ExtentTest getTest() {

        return extentTest.get();
    }


    // ============================================================
    // INFO
    // ============================================================

    public static void info(String message) {

        ExtentTest test = extentTest.get();

        if (test != null) {
            test.info(message);
        }
    }


    // ============================================================
    // PASS
    // ============================================================

    public static void pass(String message) {

        ExtentTest test = extentTest.get();

        if (test != null) {
            test.pass(message);
        }
    }


    // ============================================================
    // FAIL
    // ============================================================

    public static void fail(String message) {

        ExtentTest test = extentTest.get();

        if (test != null) {
            test.fail(message);
        }
    }


    // ============================================================
    // FAIL WITH EXCEPTION
    // ============================================================

    public static void fail(Throwable throwable) {

        ExtentTest test = extentTest.get();

        if (test != null && throwable != null) {
            test.fail(throwable);
        }
    }


    // ============================================================
    // SKIP
    // ============================================================

    public static void skip(String message) {

        ExtentTest test = extentTest.get();

        if (test != null) {
            test.skip(message);
        }
    }


    // ============================================================
    // FLUSH REPORT
    // ============================================================

    public static synchronized void flush() {

        if (extentReports != null) {
            extentReports.flush();
        }
    }



    // ============================================================
    // REMOVE CURRENT TEST
    // ============================================================
         
     public static void removeTest() {

             extentTest.remove();
   }
 }