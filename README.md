 **README.md**

---

```md
# Selenium POM Automation Framework

## Overview
This project demonstrates a Selenium automation framework built using the Page Object Model (POM) design pattern with TestNG and Maven.

The framework automates an end-to-end user flow on Amazon, including handling real-world challenges like dynamic UI elements, sponsored items, and popups.

---

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven

---

## Features
- Page Object Model (POM) design
- Config-driven browser and URL setup
- Reusable base classes (BaseTest, BasePage)
- Explicit waits and retry logic for dynamic elements
- Handles:
  - Sponsored/Ad filtering in search results
  - New tab/window handling
  - "Add Protection Plan" popup
  - Stale element issues in cart

---

## Test Scenario
1. Launch Amazon
2. Search for "TV"
3. Select the 3rd non-sponsored product
4. Capture product price
5. Add product to cart
6. Handle protection popup (click "No thanks")
7. Navigate to cart
8. Validate product price in cart

---

## Project Structure
```

src/test/java
├── base
│     └── BaseTest.java
│
├── pages
│     ├── BasePage.java
│     ├── AmazonHomePage.java
│     ├── SearchResultsPage.java
│     ├── ProductPage.java
│     └── CartPage.java
│
├── tests
│     └── AmazonTvTest.java
│
└── utils
├── ConfigReader.java
└── DriverFactory.java

src/test/resources
└── config.properties

```

---

## Configuration
Update `config.properties`:

```

browser=chrome
url=[https://www.amazon.com](https://www.amazon.com)

````

---

## How to Run
```bash
mvn clean test
````

Or run using TestNG from IntelliJ:

* Right click `AmazonTvTest`
* Run as TestNG

---

## Notes

* Framework is designed to be extendable for multiple browsers and parallel execution
* Dynamic handling implemented for real-world site behavior (Amazon)

---

## Author

Dinesh Agrawal


```
