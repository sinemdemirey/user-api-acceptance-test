# User API Acceptance Test

## 📌 Project Overview

This project automates the acceptance tests for the User API to ensure the correctness of user-related endpoints.

## 🚀 Features

- **Tested API Endpoints:**
  - Create User
  - Get User
  - Update User
  - Delete User
- **Technologies Used:**
  - **Test Framework:** TestNG
  - **API Testing:** RestAssured
  - **Wait Mechanism:** Awaitility
  - **Reporting:** Allure
  - **Logging:** Log4j, SLF4J
  - **Dependency Management:** Maven

## ⚙️ Requirements

- **Java 17**
- **Maven**

## 🛠️ Setup & Execution

### Install Dependencies

```sh
mvn clean install
```

### Run Tests

```sh
mvn test
```

## 📜 Project Structure

```
src/main/java/org/example
├── config
│   ├── ConfigReader.java
├── controller
│   ├── UserApiController.java
├── converter
│   ├── UserApiControllerData.java
├── helper
│   ├── AwaitilityUtils.java
│   ├── GeneralApiController.java
│   ├── ReadableResponse.java
├── model
│   ├── UserDTO.java
├── test
│   ├── TestListener.java
```

- **ConfigReader** → Reads configs from config.properties file.
- **Controller/Converter** → Manages API requests.
- **Helper:** → Utility classes for waiting mechanisms and API response handling.
- **Model** → Data models (`UserDTO`).
- **Test:** → Customized helper files for logging operations.

## 📧 Contact

For any issues, feel free to open an issue or contribute with a pull request!

