RestAssured-TestNG-Lombok Project

This project is an end-to-end testing suite for the Restful Booker API. It utilizes RestAssured for HTTP requests, TestNG for test execution, Lombok for simplifying data model creation, and Allure for reporting.

Table of Contents

Overview
Prerequisites
Installation
Running the Tests
Project Structure
Test Scenarios
Contributing
License
Overview

This project demonstrates end-to-end tests for the Restful Booker API, covering:

Creating a booking
Retrieving a booking
Updating a booking
Partially updating a booking
Deleting a booking
Each test is annotated with Allure descriptions, severity levels, and stories for detailed reporting.

Prerequisites

Before running the tests, ensure you have the following installed:

Java JDK 11 or higher
Maven
Git
Installation

Clone the repository:

sh
Copy code
git clone https://github.com/DonLMJ/restAssured-testng-lombok.git
cd restAssured-testng-lombok
Install dependencies:

sh
Copy code
mvn clean install
Running the Tests

To execute the tests, run:

sh
Copy code
mvn test
Project Structure

plaintext
Copy code
.
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── tests
│   │                   ├── BookingDataBuilder.java
│   │                   ├── TokenBuilder.java
│   │                   └── BaseSetup.java
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── tests
│   │                   └── RestfulBookerE2ETests.java
├── pom.xml
└── README.md
Key Files:
RestfulBookerE2ETests.java: Contains the test cases for the Restful Booker API.
BookingDataBuilder.java: Utility class for generating booking data.
TokenBuilder.java: Utility class for generating authentication tokens.
BaseSetup.java: Base class for setting up common configurations.
Test Scenarios

1. Create a Booking
Creates a new booking and validates the response.

2. Retrieve a Booking
Retrieves the newly created booking and validates the response against the initial data.

3. Update a Booking
Updates the entire booking and verifies the updated data.

4. Partially Update a Booking
Updates partial booking details and verifies the changes.

5. Delete a Booking
Deletes the booking and ensures it no longer exists.

Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.
