package com.sarker.cucumber_ui_test.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverManagerUtil {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(WebDriverManagerUtil.class);

    public WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            logger.info("Initializing WebDriver for browser: " + browser);

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    logger.error("Invalid browser specified: " + browser);
                    throw new RuntimeException("Invalid browser specified in config.properties");
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            logger.info("WebDriver initialized successfully");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Closing WebDriver...");
            driver.quit();
            driver = null;
            logger.info("WebDriver closed successfully");
        }
    }

}
