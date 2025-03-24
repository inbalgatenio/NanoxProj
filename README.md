
# Nanox Automation Project

## Overview

This project is a test automation framework for Nanox, built using **Selenium**, **Java**, and **Cucumber**. It follows the **Page Object Model (POM)** design pattern and incorporates **data-driven testing** with a configuration properties file.

## Project Structure

```
NanoxProj
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── Infra
│   │   │   │   ├── DriverManagement
│   │   │   │   │   ├── DriverManager.java
│   │   │   │   ├── FilesManagement
│   │   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── Elements
│   │   │   │   ├── Logic
│   │   │   │   ├── Pages
│   ├── test
│   │   ├── java
│   │   │   ├── Runner
│   │   │   │   ├── TestRunner.java
│   │   │   │   ├── TestDef
│   │   ├── resources
│   │   │   ├── Features
│   │   │   │   ├── Cart.feature
│   │   │   │   ├── Contact.feature
│   │   │   │   ├── Login.feature
│   │   │   │   ├── Products.feature
│   │   │   │   ├── Signin.feature
│   │   │   ├── config.properties
│── target
│── .gitignore
```

## Technologies Used

- **Programming Language**: Java
- **Test Framework**: Cucumber (Behavior-Driven Development - BDD)
- **Automation Tool**: Selenium WebDriver
- **Build Tool**: Maven
- **Configuration Management**: Properties file

## Setup Instructions

### Clone the repository

1. Clone the repository by running:
   ```bash
   git clone <repository-url>
   cd NanoxProj
   ```

### Install dependencies

2. Install the required dependencies by running:
   ```bash
   mvn clean install
   ```

### Configure properties

3. Update the `config.properties` file located in `src/test/resources` to set the required test parameters such as:
   - Browser type
   - Base URL
   - Credentials

## Running Tests

### Using Maven

- **Run all tests**:
  ```bash
  mvn test
  ```

- **Run specific feature**:
  ```bash
  mvn test -Dcucumber.options="src/test/resources/Features/Login.feature"
  ```

### Using Test Runner

You can also execute tests via **JUnit** with the following `TestRunner` class:
```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinitions")
public class TestRunner {}
```

## Configuration Management

The **`config.properties`** file is used to manage environment-specific settings like browser, base URL, timeout, and credentials. The `ConfigReader` class is responsible for reading values from this file.

## Page Object Model (POM)

The framework follows the **POM** design pattern to separate test logic from UI elements.

- Page classes are stored in the `Pages` package.
- Each page class represents a web page and contains locators and methods for interactions.

## Data-Driven Testing

Test data is managed via **Cucumber feature files** using Examples tables.

- Data-driven scenarios are implemented using **Cucumber Scenario Outline**.

## Test Execution Report

Cucumber generates an **HTML test report** after execution, showing details on passed, failed, and skipped test cases.

## Conclusion

This project provides a robust and scalable automation framework for testing Nanox web applications. The combination of **Selenium**, **Java**, **Cucumber**, and **POM** ensures maintainability and efficiency in automated testing.
