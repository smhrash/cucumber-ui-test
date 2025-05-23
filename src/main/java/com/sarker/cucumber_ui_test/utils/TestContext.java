package com.sarker.cucumber_ui_test.utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private final WebDriverManagerUtil driverManager = new WebDriverManagerUtil();

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    public void closeDriver() {
        driverManager.quitDriver();
    }
}

