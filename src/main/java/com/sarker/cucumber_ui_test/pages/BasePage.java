package com.sarker.cucumber_ui_test.pages;

import com.sarker.cucumber_ui_test.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
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

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForTitleToContain(String titlePart) {
        wait.until(ExpectedConditions.titleContains(titlePart));
    }

    protected void waitForUrlToContain(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void scrollToTheElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
    }
}
