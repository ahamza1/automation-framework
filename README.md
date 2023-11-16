# Automation Project Template

Automation project template to fast-track tests setup for Web, Mobile (iOS, Android), REST-API using popular open-source tools: TestNG, Selenium, Appium, and REST-assured. 

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Configuration](#configuration)
- [Usage](#usage)

## Project Overview

This template provides a foundational structure for automation projects, allowing quick setup without the need to invest time in configuring boilerplate code.

Project structure is based on guidelines and recommendations on testing from the [`Selenium Project`](https://www.selenium.dev/documentation/test_practices/)


The main pattern followed throughout the project structure is the [`Page Object Models Pattern`](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) also described as [`PageObject`](
https://martinfowler.com/bliki/PageObject.html)


## Features

- Write API tests using REST-assured
- Write Web UI tests using Selenium
- Write Mobile (iOS, Android) tests using Appium

## Configuration

[`environment.conf`](https://github.com/ahamza1/automation-framework/blob/master/src/test/resources/environment.conf) - [HOCON](https://github.com/lightbend/config) file is a control center for the project. Put needed properties and get them in the code with functionality included in [`Environment.java`](https://github.com/ahamza1/automation-framework/blob/master/src/main/java/org/testautomation/core/environment/Environment.java)

## Usage

Run tests by executing command from the root of the project folder:
- Linux/MacOS: ./gradlew clean test -Denv=desktop.chrome -DincludeGroups=web.test.example
- Windows: ./gradlew.bat clean test -Denv="desktop.chrome" -DincludeGroups="web.test.example"
- API: ./gradlew clean test -Denv=api -DincludeGroups=api.test.example





