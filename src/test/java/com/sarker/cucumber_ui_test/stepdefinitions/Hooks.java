package com.sarker.cucumber_ui_test.stepdefinitions;

import com.sarker.cucumber_ui_test.pages.BasePage;
import com.sarker.cucumber_ui_test.utils.ConfigReader;
import com.sarker.cucumber_ui_test.utils.TestContext;
import com.sarker.cucumber_ui_test.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private final TestContext context;
    private WebDriver driver;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup() {
        driver = context.getDriver();
        driver.get(ConfigReader.getBaseUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                try {
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";

                    File screenshotDir = new File("screenshots");
                    if (!screenshotDir.exists()) {
                        screenshotDir.mkdirs();
                    }

                    File destination = new File(screenshotDir, screenshotName);
                    FileUtils.copyFile(screenshot, destination);
                    System.out.println("📸 Screenshot saved to: " + destination.getAbsolutePath());

                } catch (IOException e) {
                    System.err.println("❌ Failed to save screenshot: " + e.getMessage());
                }
            }

            WebDriverManagerUtil.quitDriver(); // make sure method name is correct
        }
    }

}
