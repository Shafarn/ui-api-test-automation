# API & UI Test Automation Project

This repository contains automated tests for both API (https://dummyapi.io) and UI (https://www.demoblaze.com) of an e-commerce platform using Cucumber, Selenium WebDriver, Java, and other related technologies.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [How to Run Tests](#how-to-run-tests)

## Technologies Used

- **Programming Language:** Java
- **Test Framework:** Cucumber
- **Selenium WebDriver:** For UI testing
- **HTTP Client Libraries:** For API testing
- **Browser Driver:** ChromeDriver for headless Chrome
- **Faker:** To generate fake data
- **JUnit:** For assertions and test management

## Project Structure

The project is structured to separate concerns between different components of the application under test:

```
test
├── java
    ├── api
        ├── features
        ├── objects
        ├── stepDef
    ├── ui
        ├── features
        ├── pages
        ├── stepDef
    ├── APITest
    ├── UITest
```

## How to Run Tests

### Prerequisites
1. **Java JDK 8 or later** - Ensure that Java is installed on your machine.
2. **Node.js (if using npm for package management)** - If you need any Node.js packages, ensure it's installed.
3. **Git** - For cloning the repository.

### Steps to Run Tests

1. **Clone the Repository**
   ```sh
   git clone https://github.com/Shafarn/ui-api-test-automation.git
   cd ui-api-test-automation
   ```

2. **Build the Project**
   ```sh
   ./gradlew build
   ```

3. **Run UI Tests**
   ```sh
   ./gradlew webTest
   ```

4. **Run API Tests**
   ```sh
   ./gradlew apiTest
   ```

### Reports
- The tests will generate reports in the `reports` directory:
  - HTML report: `reports/ui-test-report.html`
  - JSON report: `reports/ui-test-report.json`
  
- For API tests, the report will be saved as `reports/api-test-report.html`.

These steps should help you set up and run the automated tests for both UI and API components of your e-commerce platform.
