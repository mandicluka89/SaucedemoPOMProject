# Saucedemo POM Project

This project contains automated tests for the web application  
https://www.saucedemo.com/ 

## Dependencies ##
- Run on Windows 11 OS
- IDE for this project is IntelliJ Idea Community Edition 2025.2.3
- Browsers needed is Firefox as mandatory but also preferred are Chrome, Edge and Safari

## Technologies ##
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## Project Structure ##


```
SaucedemoPOMProject/
├── src/
│   └── test/
│       └── java/
│           ├── pages
│           └── tests
├── pom.xml
├── LoginUsers.xlsx
└── README.md
```

The src/test/java directory contains:
- Page classes representing application pages
- Test classes containing TestNG test cases

## How to Run Tests ##

1. Clone the repository:

- git clone https://github.com/mandicluka89/SaucedemoPOMProject.git

2. Navigate to the project directory:

- cd SaucedemoPOMProject

3. Run tests using Maven:

- mvn clean test

4. Alternatively, tests can be run directly from an IDE (IntelliJ IDEA or Eclipse) by running the TestNG test classes.

## Tested Scenarios ##

The project covers typical SauceDemo application scenarios:
- Successful login with valid credentials
- Login failure with invalid or without credentials
- Sorting products by alphabetical order and by price
- Adding products to the shopping cart
- Removing products from the shopping cart 
- Cart validation
- Checkout process
- Social links
- Logout process

## Prerequisites ##

Before running the tests, make sure you have:
- Java JDK 8 or higher
- Maven
- Google Chrome
- Compatible ChromeDriver
- IDE (optional)

## Framework Walkthorugh ##
Packages:

- Base - Contains classes used through the app
- Pages - Contains classes for each page
- Tests - Contains test classes

### Files: ###

- pom.xml - Contains all dependencies used in the project (last updated:24.12.2025.)
- LoginUsers.xlsx - Excel file used to read some data for DDT as an alternative
- .gitignore - File used to store all items that are not pushed to github

## Author ##

Luka Mandić  
GitHub: https://github.com/mandicluka89
 