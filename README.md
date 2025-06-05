# Selenium Cucumber UI Test Framework

This project is a Java-based UI test automation framework using:

* **Selenium WebDriver** for browser automation
* **Cucumber (Gherkin)** for BDD-style test scenarios
* **TestNG** for test execution
* **Log4j** for logging
* **PicoContainer** for dependency injection
* **Maven Cucumber Reporting** for rich HTML reports
* **Jenkins** for CI/CD integration

## 📁 Project Structure

```
├── src
│   ├── main
│   │   └── java
│   │       └── com.sarker.cucumber_ui_test
│   │           ├── pages
│   │           └── utils
│   └── test
│       └── java
│           └── com.sarker.cucumber_ui_test
│               ├── stepdefinitions
│               └── testrunners
│       └── resources
│           └── features
├── pom.xml
├── testng.xml
└── README.md
```

## ✅ Features

* Cross-browser support (Chrome, Firefox, Edge, Safari)
* Configurable environments via `config.{env}.properties`
* Explicit waits with WebDriverWait
* Screenshot capture on failure
* Scalable Page Object Model (POM)
* Integrated with Jenkins for continuous test execution

## ⚙️ How to Run Tests

### 1. Install Dependencies

```
mvn clean install

```
### 2. Execute testcases and generate report

```
mvn clean verify

```

### 3. Run with TestNG

```
mvn test
```

### 4. Set environment (optional)

```
mvn test -Denv=qa
```

## 🧪 Sample Feature File

```
Feature: Selenium Homepage

  Scenario: Verify homepage title
    Given I open the Selenium homepage
    Then I wait for the title to contain "Selenium"
    Then the page title should contain "Selenium"

  Scenario: Verify logo is displayed
    Given I open the Selenium homepage
    Then I wait for the Selenium logo to be visible
    Then the Selenium logo should be visible
```

## 🔧 Config File Example (config.prod.properties)

```
browser=chrome
base.url=https://www.selenium.dev/
```

## 📦 Dependencies (pom.xml)

* Selenium Java
* TestNG
* Cucumber Java & TestNG
* PicoContainer
* Log4j
* Maven Cucumber Reporting

## 🖼️ Cucumber HTML Reports

### Local Maven Execution:

The report is generated after running:

```
mvn clean verify
```

* JSON Output: `target/cucumber-reports.json`
* HTML Report Output: `target/cucumber-html-reports/overview-features.html`

### Jenkins Configuration:

To see the same HTML report in Jenkins:

1. **Install Plugin**: Install `HTML Publisher Plugin` in Jenkins.
2. **Configure Post-build Action**:

    * Go to your Jenkins job > Configure.
    * Add **Post-build Action** > **Publish HTML reports**.
    * Set:

        * **HTML directory to archive**: `target/cucumber-html-reports`
        * **Index page\[s]**: `overview-features.html`
        * **Report title**: `Cucumber Test Report`
3. **Build**: Execute the job.
4. **View Report**: Click **Cucumber Test Report** link on the left panel of your job page.

## 📌 Notes

* Make sure Maven is available on the Jenkins server path.
* Ensure Jenkins executes the correct `mvn clean verify` goal.
* If your report is not visible, validate the JSON file is created in the correct path.

## 📃 License

This project is for educational/demo purposes and not licensed for production use.
