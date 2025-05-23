package com.sarker.cucumber_ui_test.pages;

import com.sarker.cucumber_ui_test.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToTheHomepage() {
        String url = ConfigReader.getBaseUrl();
        System.out.println("Navigating to: " + url);
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickWhenReady(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitForTitleToContain(String titlePart) {
        wait.until(ExpectedConditions.titleContains(titlePart));
    }

    protected void waitForUrlToContain(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }
}
