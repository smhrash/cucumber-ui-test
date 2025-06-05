package com.sarker.cucumber_ui_test.stepdefinitions;

import com.sarker.cucumber_ui_test.pages.Homepage;
import com.sarker.cucumber_ui_test.utils.TestContext;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyStepdefs {

    private final WebDriver driver;
    private final Homepage homepage;

    public MyStepdefs(TestContext context) {
        this.driver = context.getDriver();
        this.homepage = new Homepage(driver);
    }

    @Given("I open the Selenium homepage")
    public void iOpenTheSeleniumHomepage() {
        System.out.println("I am in Homepage");
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @Then("the Selenium logo should be visible")
    public void theSeleniumLogoShouldBeVisible() {
        assertTrue(homepage.isLogoVisible());
    }

    @When("I click on the documentation link")
    public void iClickOnTheDocumentationLink() {
        homepage.clickOnDocumentationLink();
    }

    @And("I click on the link About this documentation")
    public void iClickOnTheLinkAboutThisDocumentation() {
        homepage.clickOnAboutThisDocumentationLink();
    }

    @Then("I should see the title text {string}")
    public void iShouldSeeTheTitleText(String text) {
        System.out.println(homepage.getThisDocumentationText());
        System.out.println(text);
        assertEquals(homepage.getThisDocumentationText(), text);
    }
}
