package com.yourcompany.automation.utils;

import com.yourcompany.automation.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    private WaitUtils() {
        // Prevent object creation
    }

    // Wait until element is visible
    public static WebElement waitForVisibility(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    // Wait until element is clickable
    public static WebElement waitForClickable(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Wait until element is present in DOM
    public static WebElement waitForPresence(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    // Wait until element disappears
    public static boolean waitForInvisibility(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    // Wait until title contains given text
    public static boolean waitForTitleContains(String title) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.titleContains(title)
        );
    }

    // Wait until URL contains given text
    public static boolean waitForUrlContains(String url) {

        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );

        return wait.until(
                ExpectedConditions.urlContains(url)
        );
    }
    
    
    
    
    
    
}