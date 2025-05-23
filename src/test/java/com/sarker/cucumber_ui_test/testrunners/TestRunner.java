package com.sarker.cucumber_ui_test.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/sarker/cucumber_ui_test/stepdefinitions",
        plugin = {"pretty",
                "json:target/cucumber-reports.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true
//        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
