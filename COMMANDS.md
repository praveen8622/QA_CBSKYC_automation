# KYC Cus Reg - Helpful Commands

This document contains a list of useful Maven and Allure commands to run tests and generate reports in this project.

## Running Tests

### 1. Run All Tests
Runs all tests defined in `pom.xml` (which currently points to `cust_reg.xml`). 
```bash
mvn test
```

### 2. Clean and Run All Tests 
Deletes the `target/` directory (which includes old reports and compiled classes) before running all tests. This ensures a fresh test execution and report generation.
```bash
mvn clean test
```

### 3. Run a Specific Test Class
Runs just one test class. Useful when you are debugging a specific feature.
```bash
# Example: Run only the CorporateCustRegTest
mvn test -Dtest=CorporateCustRegTest
```

### 4. Run a Specific Test Method (Test Case)
Runs a single test case within a specific class. 
```bash
# Example: Run only the verifyIdentityDetails method inside CorporateCustRegTest
mvn test -Dtest=CorporateCustRegTest#verifyIdentityDetails
```


## Generating and Viewing Allure Reports

> **Note:** These commands require you to have run tests at least once (e.g., `mvn clean test`) so that raw results exist in `target/allure-results`.

### 1. Serve the Report (Recommended)
This command generates the HTML report in a temporary folder and automatically opens it in your default web browser on a local web server (usually `localhost:50504`).
```bash
mvn allure:serve
```

### 2. Generate the HTML Report (Without serving)
This command generates the static HTML report inside `target/site/allure-maven-plugin`. It will not open the browser automatically.
```bash
mvn allure:report
```

### 3. Clean Allure Results (Without cleaning compiled code)
If you just want to clear old Allure results without recompiling your whole project, you can delete the results folder manually before running tests.
```bash
# PowerShell
Remove-Item -Recurse -Force target\allure-results

# Bash/Git Bash
rm -rf target/allure-results

```
