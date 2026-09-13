package com.yourcompany.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String screenshotDirectory =
                System.getProperty("user.dir")
                + "/screenshots/";

        String filePath =
                screenshotDirectory
                + testName
                + "_"
                + timestamp
                + ".png";

        try {

            // Create screenshots directory if it doesn't exist
            File directory =
                    new File(screenshotDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Take screenshot
            TakesScreenshot takesScreenshot =
                    (TakesScreenshot) driver;

            File sourceFile =
                    takesScreenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            // Destination
            File destinationFile =
                    new File(filePath);

            // Copy screenshot
            FileUtils.copyFile(
                    sourceFile,
                    destinationFile
            );

            System.out.println(
                    "Screenshot saved at: "
                    + filePath
            );

            return filePath;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot",
                    e
            );
        }
    }
}