package com.sarker.cucumber_ui_test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

    @FindBy(xpath = "//*[@id='Layer_1']")
    private WebElement seleniumLogo;
    @FindBy(xpath = "//a[@class='nav-link']//span[contains(text(),'Documentation')]")
    private WebElement documentationLink;
    @FindBy(xpath = "//a[normalize-space()='About this documentation']")
    private WebElement aboutThisDocumentationLink;
    @FindBy(css = "div[class='td-content'] h1")
    private WebElement aboutThisDocumentationTitle;

    public Homepage(WebDriver driver) {
        super(driver);
        // Optional: if a different wait time is required, override it here
    }

    public boolean isLogoVisible() {
        waitForElementToBeVisible(seleniumLogo);
        return seleniumLogo.isDisplayed();
    }

    public void clickOnDocumentationLink() {
        scrollToTheElement(documentationLink);
        waitForElementToBeClickable(documentationLink);
        documentationLink.click();
    }

    public void clickOnAboutThisDocumentationLink() {
        scrollToTheElement(aboutThisDocumentationLink); // Scroll to make sure it's visible
        waitForElementToBeClickable(aboutThisDocumentationLink); // Wait for it to be ready

        try {
            aboutThisDocumentationLink.click(); // Try normal click
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Fallback: force-click using JavaScript if something is blocking it
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", aboutThisDocumentationLink);
        }
    }

    public String getThisDocumentationText() {
        waitForElementToBeVisible(aboutThisDocumentationTitle);
        return aboutThisDocumentationTitle.getText();
    }

}
