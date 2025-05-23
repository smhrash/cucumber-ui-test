# Selenium Cucumber UI Test Framework

This project is a Java-based UI test automation framework using:

* **Selenium WebDriver** for browser automation
* **Cucumber (Gherkin)** for BDD-style test scenarios
* **TestNG** for test execution
* **Log4j** for logging
* **PicoContainer** for dependency injection

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
│               └── runners
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
* Proper WebDriver management with `TestContext`
* Scalable Page Object Model (POM)

## ⚙️ How to Run Tests

### 1. Install Dependencies

```
mvn clean install
```

### 2. Run with TestNG

```
mvn test
```

Or via IntelliJ/Eclipse using `testng.xml`.

### 3. Set environment (optional)

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
* Cucumber Java
* Cucumber TestNG
* PicoContainer
* Log4j

## 🖼️ Screenshots on Failure

If a test scenario fails, a screenshot is automatically captured and saved to the `screenshots/` directory. To enable this:

* The `@After` hook in `Hooks.java` uses `TakesScreenshot`.
* Screenshots are named based on the scenario title and saved as `.png` files.
* Ensure the `screenshots/` directory is created (automatically handled).

You can find them in:

```
screenshots/<failed_scenario_name>.png
```

## 📌 Notes

* Ensure `chromedriver` or respective browser drivers are in your system path.
* Use `WebDriverManager` if preferred to avoid managing driver binaries manually.

## 📃 License

This project is for educational/demo purposes and not licensed for production use.
# cucumber-ui-test
