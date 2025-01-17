package com.example.Hospital.Management.Controllers; // Declares the package name, grouping related classes under this namespace.

import com.example.Hospital.Management.Models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap; // Imports HashMap class, allowing us to store and retrieve patient data using key-value pairs.
import java.util.List;

@RestController // Indicates that this class is a REST controller that handles HTTP requests and returns JSON responses.
public class PatientController { // Declares the PatientController class.

    HashMap<Integer, Patient> patientDb = new HashMap<>(); // Creates an in-memory database (HashMap)
                                                           // to store patients with Integer keys (patientId)
                                                           //and Patient objects as values.

    @PostMapping("/addPatientViaParameters") // Maps this method to a POST request at the URL "/addPatientViaParameters".
    public String addPatient(@RequestParam("patientId") Integer patientId, @RequestParam("name") String name,
                             @RequestParam("age") Integer age, @RequestParam("disease") String disease) { // Defines the addPatient method that accepts parameters patientId, name, age, and disease from the request URL.

        Patient patient = new Patient(patientId, name, disease, age); // Creates a new Patient object with the provided details.
        patientDb.put(patientId, patient); // Stores the patient object in the patientDb HashMap, using patientId as the key.

        return "Patient information added via @RequestParam"; // Returns a confirmation message indicating that the patient was successfully added.
    }



    @PostMapping("/addPatientDetailViaRequestBody") // Maps this method to a POST request at the "/addPatientDetailViaRequestBody" URL.
    public String addPatient(@RequestBody Patient patient) { // Defines the addPatient method, taking a Patient object from the request body.

        int key = patient.getPatientId(); // Retrieves the patient ID from the Patient object and stores it in the variable 'key'.

        patientDb.put(key, patient); // Adds the Patient object to the patientDb HashMap, with the patient ID as the key.

        return "Patient information added via @RequestBody"; // Returns a success message confirming the patient was added.
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient){
        int key = patient.getPatientId();
        if (patientDb.containsKey(key)){
            patientDb.put(key,patient);
            return "Patient details updated successfully";
        }
        return "Data does not exist";
    }

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId") Integer patientId, @RequestParam("disease") String disease){

        if(patientDb.containsKey(patientId)){
            Patient patient = patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId,patient);

            return "Disease updated successfully for patient ID: " + patientId;
        }
        else {
            // Return an error message if the patient ID does not exist.
            return "Patient not found with ID: " + patientId;
        }
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId") Integer patientId){
        if (patientDb.containsKey(patientId)) {
            patientDb.remove(patientId);
            return "Patient has been deleted";
        } else {
            return "Patient not found";
        }
    }

    @GetMapping("/getPatientInfo") // Maps this method to handle HTTP GET requests at the "/getPatientInfo" URL.
    public Patient getPatient(@RequestParam("patientId") Integer patientId) { // Defines the getPatient method, which expects a "patientId" parameter from the request URL.

        Patient patient = patientDb.get(patientId); // Retrieves the Patient object associated with the provided patientId from the patientDb HashMap.

        return patient; // Returns the retrieved Patient object. If no Patient with this ID exists, it returns null.
    }
    @GetMapping("/getPatientViaPathVariable/{patientId}")
    public Patient getPatientInfo(@PathVariable("patientId") Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getPatientsByAgeAndDisease/{age}/{disease}")
    public List<Patient> getPatientsByAgeAndDisease(@PathVariable("age") Integer age,
                                                    @PathVariable("disease") String disease) {
        List<Patient> matchingPatients = new ArrayList<>();

        // Iterate through each patient in the database to find matches
        for (Patient patient : patientDb.values()) {
            if (patient.getAge() > age && patient.getDisease().equals(disease)) {
                matchingPatients.add(patient);
            }
        }  

        return matchingPatients;
    }


    @GetMapping("/getAllPatients") // Maps this method to handle HTTP GET requests at the "/getAllPatients" URL.
    public List<Patient> getAllPatients() { // Declares a method that returns a list of Patient objects.

        List<Patient> patients = new ArrayList<>(); // Initializes an empty list to store all Patient objects.

        for(Patient p : patientDb.values()) { // Iterates over each Patient object in the values of the patientDb HashMap.
            patients.add(p); // Adds each Patient object from the HashMap to the 'patients' list.
        }

        return patients; // Returns the list of all patients. This list will be converted to JSON and sent as the response.
    }
    // Maps HTTP GET requests to "/getPatientByName" to this method.

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name) {

        // Loops through each patient (p) in the collection of patients from patientDb.
        for (Patient p : patientDb.values()) {

            // Checks if the name of the current patient (p) matches the provided name.
            if (p.getName().equals(name)) { // .equals() is used to compare strings in Java

                // If a match is found, return the current patient (p) object.
                return p;
            }
        }

        // If no matching patient is found, null is implicitly returned (optional - could throw
        // an exception or return a message)
        return null;
    }

    // Maps HTTP GET requests to "/getAllPatientListGreaterThanAge" to this method.
    @GetMapping("/getAllPatientListGreaterThanAge")
    public List<Patient> getAllPatientListGreaterThanAge(@RequestParam("age") Integer age) {

        // Creates a new list to store patients whose age is greater than the specified age.
        List<Patient> patients = new ArrayList<>();

        // Loops through each patient (p) in the collection of patients from patientDb.
        for (Patient p : patientDb.values()) {

            // Checks if the current patient's age is greater than the specified age.
            if (p.getAge() > age) {

                // If the patient's age is greater than the specified age, adds the patient to the list.
                patients.add(p);
            }
        }

        // Returns the list of patients with age greater than the specified age.
        return patients;
    }

}







