# Automation Framework

Hybrid Test Automation Framework developed using Selenium WebDriver, TestNG, Rest Assured, and Maven.

This project combines both UI Automation and API Automation in a single Maven framework following reusable and scalable automation practices.

---

# Tech Stack

## UI Automation
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## API Automation
- Rest Assured
- JSONPlaceholder API

---

# Framework Features

- Page Object Model (POM)
- Reusable Test Components
- Maven Build Management
- TestNG Test Execution
- API + UI Combined Framework
- Assertions and Validations
- GitHub Integrated Project
- Organized Package Structure

---

# Project Structure

bash
src/test/java
│
├── api.tests
│
├── ui.base
├── ui.pages
├── ui.tests


---

# UI Automation Test Scenarios

## TC-01 Login Validation
- Login using valid credentials
- Verify successful login and inventory page navigation

## TC-02 Locked Out User Validation
- Login using locked user credentials
- Verify proper error message is displayed

## TC-03 Product Sorting Validation
- Sort products from low price to high price
- Validate sorting functionality

## TC-04 Cart Validation
- Add multiple products to cart
- Remove product from cart
- Verify cart badge count updates correctly

## TC-05 Checkout Validation
- Complete checkout process
- Validate order confirmation message

---

# API Automation Coverage

API automation implemented using Rest Assured with JSONPlaceholder APIs.

## Validations Performed
- Status code validation
- Response body validation
- JSON response parsing
- Endpoint verification
- Basic API response checks

## Endpoints Covered
- Users
- Posts
- Comments
- Albums
- Photos

---

# Tools and Design Patterns Used

- Selenium WebDriver
- Rest Assured
- TestNG
- Maven
- Page Object Model (POM)

---

# Run Project Using Maven

bash
mvn clean test


---

# Run TestNG Suite

bash
Right Click on testng.xml → Run As → TestNG Suite


---

# Clone Repository

bash
git clone https://github.com/prathameshsoftwaretester/automation-framework.git


---

# Maven Dependencies Used

- Selenium Java
- TestNG
- WebDriverManager
- Rest Assured

---

# Future Improvements

- Extent Reports Integration
- Data Driven Testing
- Excel/JSON Utility Support
- Jenkins CI/CD Integration
- Cross Browser Execution

---

# Author

Prathamesh Vinayak Sawant
