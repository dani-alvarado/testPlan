# Test Automation Framework by Daniel Alvarado

This is a test automation framework built using Selenium, TestNG, and Java for web application testing. For the discussion part check out the _Technical Test_ folder.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Test Data](#test-data)
- [Reporting](#reporting)
- [Git Versioning](#git-versioning)

## Overview

The test automation framework is designed to automate the testing of web applications using Selenium WebDriver. It provides a structured and organized approach to writing and executing automated tests, making it easy to maintain and extend the test suite.

The framework uses TestNG as the testing framework, allowing the creation of test cases using annotations. It includes a set of utility methods and page object models for interacting with web elements and performing common actions.

## Features

- Page Object Model (POM) design pattern for improved maintainability and reusability.
- Configuration file for managing test data and settings.
- TestNG annotations for easy test case creation and execution.
- Utility methods for handling common operations, such as waiting for elements, taking screenshots, etc.
- Custom listeners for capturing test events

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven build tool
- Selenium WebDriver
- TestNG
- Web browser drivers (e.g., ChromeDriver, GeckoDriver)

## Setup

1.  Clone the repository to your local machine.

    `git clone https://github.com/dani-alvarado/testPlan.git`

2.  Install the required dependencies using Maven.

    `cd testPlan
mvn clean install`

3.  Set up the configuration file with the necessary test data and settings. Modify the `config.properties` file located in the `src/test/resources` directory.

## Running Tests

1.  To run the entire test suite, execute the following command:

    `mvn test`

## Test Data

Test data is managed through the `config.properties` file located in the `src/test/resources` directory. Create the file and update the properties to set the necessary test data, such as URLs, usernames, passwords, etc. You can access the test data in your test classes using the `config.getProperty("propertyName")` method.

## Reporting

After running the tests, an HTML report will be generated. This was done using _Extent Reports_, to visualize it just open it in a browser.

## Git Versioning

For the purpose of this exercise, the branching strategy used was GitFlow with pull requests. To check that you can take a look at the branches and the pull requests closed