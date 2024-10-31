Hospital Management System API

This Hospital Management System is a RESTful API built using Spring Boot to manage basic patient data. 
This project provides functionalities to add, retrieve, and filter patient records, making it a foundational tool for healthcare data management. 
It is ideal for development, learning, and small-scale healthcare applications.

Features:

Add Patient Records: Add patients using URL parameters or request body.
Retrieve Patient Information: Fetch details of patients by ID or name.
Filter Patients by Age: Retrieve a list of patients older than a specified age.
List All Patients: View all stored patient records.

Technology Stack
Backend: Java, Spring Boot

Data Storage: In-memory HashMap (for demonstration purposes)
API Testing: Postman or any preferred API client

Prerequisites
Ensure you have the following installed:

Java Development Kit (JDK): Version 11 or higher
Maven: For building and running the application
Git: To clone the repository

Installation and Setup
Step 1: Clone the Repository
Clone this repository to your local machine:

bash
Copy code
git clone https://github.com/your-username/hospital-management-system.git
cd hospital-management-system

Step 2: Build the Project
Use Maven to build the project:

bash
Copy code
mvn clean install

Step 3: Run the Application
Start the application using the following command:

bash
Copy code
mvn spring-boot:run
The server will run at http://localhost:8081.

API Endpoints

1. Add Patient via URL Parameters
URL: POST /addPatientViaParameters
Description: Adds a patient record using URL parameters.
Parameters:
patientId (Integer): Unique patient ID.
name (String): Patient's name.
age (Integer): Patient's age.
disease (String): Condition of the patient.
Response: Confirms that patient data was added.

3. Add Patient via JSON Request Body
URL: POST /addPatientDetailViaRequestBody
Description: Adds a patient using a JSON request body.
Request Body Example:
json
Copy code
{
  "patientId": 101,
  "name": "John Doe",
  "age": 45,
  "disease": "Hypertension"
}
Response: Confirms that patient data was added.

5. Get Patient by ID
URL: GET /getPatientInfo
Description: Fetches patient details by patientId.
Parameters: patientId (Integer)
Response: Returns the patient data.

7. Get Patient by Name
URL: GET /getPatientByName
Description: Fetches a patient by their name.
Parameters: name (String)
Response: Returns the patient data if a match is found.

9. Get All Patients
URL: GET /getAllPatients
Description: Retrieves all patient records.
Response: A list of all patients.

11. Get All Patients Older Than a Specified Age
URL: GET /getAllPatientListGreaterThanAge
Description: Filters patients by age.
Parameters: age (Integer)
Response: Returns a list of patients over the specified age.
Usage Examples
Add a Patient via Parameters:
POST http://localhost:8081/addPatientViaParameters?patientId=101&name=John Doe&age=45&disease=Hypertension
Retrieve a Patient by ID:
GET http://localhost:8081/getPatientInfo?patientId=101
Get All Patients Over a Certain Age:
GET http://localhost:8081/getAllPatientListGreaterThanAge?age=30
Future Enhancements
Database Integration: Replace the in-memory HashMap with a persistent database.
Input Validation: Improve data validation for added reliability.
Enhanced Functionality: Add features like appointment scheduling, medical records, and billing.
License
This project is licensed under the MIT License
