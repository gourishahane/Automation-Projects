# Automated Google Form Submission

## Project Title
Automating Google Form Submission with Dynamic Inputs Using Selenium

## Description
This project automates the end-to-end submission of a Google Form, encompassing a variety of input elements and dynamic data entry. 
Key features include the use of wrappers for reusable methods, dynamic date and time calculations, and validations to ensure successful form submission.

### Key Features
- Navigation: Automatically navigates to the specified Google Form URL.
- Dynamic Text Input: Fills in text fields with dynamic values, including the current epoch time.
- Radio Button Selection: Selects options based on user input dynamically.
- Checkbox Selection: Handles multiple checkbox selections based on predefined skills.
- Dropdown Selection: Selects an option from a dropdown menu dynamically.
- Date Calculation: Calculates and inputs a date (current date minus 7 days).
- Time Input: Fills in a specific time (07:30) using dynamic input fields.
- Submission and Validation: Submits the form and validates the success message.
  This project demonstrates the power of Selenium WebDriver for dynamic web interactions and the importance of reusable wrapper methods for clean and maintainable code.

## Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/gourishahane/Google-Form-Automation.git

2. Set up the environment:
- Install Java 11 or above.
- Download and install ChromeDriver compatible with your browser version.
- Install Maven or Gradle for dependency management.
- Add the required dependencies for Selenium and TestNG in the build file (e.g., pom.xml or build.gradle).

2. Navigate to the project directory:
   cd ME_QA_XGOOGLE_FORM_MODULE_L1
   
3. Build the project using Gradle:
   gradle build
   
4. Set up the required browser drivers (e.g., ChromeDriver) and ensure they are in the system path.

5. Execute tests using TestNG:
   gradle test

## Usage
- Run the Test Case: Execute the TestNG test class to navigate to the Google Form and complete the automation flow.
- Key Functions:
Wrappers: Reusable methods for entering text, selecting radio buttons and checkboxes, and handling dropdowns.
Dynamic Date and Time: Automatically calculates and formats the date and time for input fields.
Validation: Verifies the success message displayed on the form post-submission.
- Output:
Console logs for each step of the automation process, including entered text, selected options, and the success message.
Screenshots or logs can be added for additional debugging if required.

## Dependencies
- Selenium WebDriver
- TestNG for testing and assertions
- Gradle as the build tool


## Contact Information
- Name: Gouri Shahane
- Email: gouri.shahane@example.com
- GitHub: github.com/gourishahane
- LinkedIn: linkedin.com/in/gourishahane










