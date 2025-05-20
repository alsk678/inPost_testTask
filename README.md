# InPost Test Task

This project is a Test Automation Framework (TAF) designed for automated end-to-end testing of an iOS 
mobile application. It leverages Appium for mobile interaction, Selenium for WebDriver capabilities, 
and TestNG for test execution and management. The framework focuses on validating critical test cases, 
and is structured for maintainability and scalability.

## Project Structure

- **src/main/java**: Contains the main application code.
  - **pageobject**: Page Object Model classes for different screens (e.g., LoginPage, CatalogPage, CartPage, etc.).
  - **driver**: Classes for managing the Appium driver.
  - **property**: Configuration properties for iOS and Appium.
  - **utility**: Utility classes for retry logic and other helpers.
  - **data**: Constants and variables used in tests.
- **src/test/java**: Contains test scripts.
  - **testscripts**: Contains the main end-to-end test script (EndToEndTest.java).
- **src/main/resources**: Contains configuration files (e.g., ios.properties).
- **testng.xml**: Contains TestNG configuration.

## Prerequisites

- Java 19
- Maven
- Appium Server
- iOS Simulator or Device
- Xcode (for iOS development)

## Configuration

1. Ensure the Appium server is running at the URL specified in `src/main/resources/ios.properties`.
2. Update the `ios.properties` file with your device details:
   - `appium.server.url`: URL of the Appium server (default: http://127.0.0.1:4723)
   - `ios.device.name`: Name of the iOS device or simulator
   - `ios.platform.version`: iOS platform version
   - `ios.udid`: UDID of the iOS device (check in XCode -> Window -> Devices and Simulator -> Simulators)
   - `ios.no.reset`: Whether to reset the app state
   - `ios.app.path`: Path to the iOS app file in your system
   - `default.timeout`: Default timeout for element visibility

## Running Tests

To run the tests, start Appium Server 

```bash
appium
```

and use the following Maven command:

```bash
mvn clean test
```

This will execute the TestNG suite defined in `testng.xml`.

## Test Flow

The main test (`EndToEndTest.java`) performs the following steps:
1. Logs in as a standard user.
2. Verifies that items are loaded in the catalog.
3. Adds an item to the cart and verifies the cart icon updates.
4. Navigates to the cart and verifies the item details.
5. Proceeds to checkout, fills in user information, and completes the order.
6. Verifies the order confirmation.

## Retry Logic

The test uses a `RetryAnalyzer` to retry failed tests up to 2 times.

## Dependencies

- TestNG
- Appium Java Client
- Selenium Java
- SLF4J
- Logback
