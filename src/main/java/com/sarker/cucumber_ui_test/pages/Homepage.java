package com.sarker.cucumber_ui_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

    @FindBy(xpath = "//*[@id='Layer_1']")
    private WebElement seleniumLogo;

    public Homepage(WebDriver driver) {
        super(driver);
        // Optional: if a different wait time is required, override it here
    }

    public boolean isLogoVisible() {
        waitForElement(seleniumLogo);
        return seleniumLogo.isDisplayed();
    }
}
