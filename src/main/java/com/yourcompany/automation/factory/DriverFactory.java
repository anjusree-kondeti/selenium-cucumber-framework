package com.yourcompany.automation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.yourcompany.automation.utils.ConfigReader;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes WebDriver based on the browser name.
     *
     * @param browser Browser name: chrome, firefox, edge
     * @return WebDriver instance
     */
    public static WebDriver initDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                webDriver = new ChromeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser: " + browser +
                        ". Supported browsers: chrome, firefox, edge"
                );
        }

        webDriver.manage().window().maximize();
        int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        driver.set(webDriver);

        return webDriver;
    }

    /**
     * Returns the WebDriver instance associated
     * with the current thread.
     */
    public static WebDriver getDriver() {

        if (driver.get() == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized. " +
                    "Call initDriver() before getDriver()."
            );
        }

        return driver.get();
    }

    /**
     * Quits the browser and removes the driver
     * from the current thread.
     */
    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}