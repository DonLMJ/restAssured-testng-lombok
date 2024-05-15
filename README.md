# RestAssured-TestNG-Lombok Project

This project is an end-to-end testing suite for the [Restful Booker API](https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings). It utilizes RestAssured for HTTP requests, TestNG for test execution, Lombok for simplifying data model creation, and Allure for reporting.

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Test Scenarios](#test-scenarios)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project demonstrates end-to-end tests for the Restful Booker API, covering:
- Creating a booking
- Retrieving a booking
- Updating a booking
- Partially updating a booking
- Deleting a booking

Each test is annotated with Allure descriptions, severity levels, and stories for detailed reporting.

## Prerequisites

Before running the tests, ensure you have the following installed:
- Java JDK 11 or higher
- Maven
- Git

## Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/DonLMJ/restAssured-testng-lombok.git
   cd restAssured-testng-lombok
