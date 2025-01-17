//package com.example.Hospital.Management.Repositories;
//
//import com.example.Hospital.Management.Models.Nurse;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.List;
//
//@Repository
//public class NurseRepository {
//    HashMap<Integer, Nurse> nurseDb = new HashMap<>();
//    public String addNurse(Nurse nurse){
//        int key = nurse.getNurseId();
//        nurseDb.put(key,nurse);
//        return "Nurse added successfully ";
//    }
//
//    public List<Nurse> getAllNurses(){
//        return nurseDb.values().stream().toList();
//    }
//}


package com.example.Hospital.Management.Repositories;

// Importing necessary packages
import com.example.Hospital.Management.Models.Nurse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

// Marks this class as a Repository, which is a stereotype annotation in Spring indicating
// that this class interacts with the database layer
@Repository
public class NurseRepository {

    // A HashMap to simulate the database, where the key is nurseId and the value is a Nurse object
    HashMap<Integer, Nurse> nurseDb = new HashMap<>();

    /**
     * Method to add a Nurse object to the database
     * @param nurse - The Nurse object to be added
     * @return String - A confirmation message indicating the addition was successful
     */
    public String addNurse(Nurse nurse) {
        // Fetching the unique ID of the nurse
        int key = nurse.getNurseId();

        // Adding the nurse object to the HashMap (simulated database) with nurseId as the key
        nurseDb.put(key, nurse);

        // Returning a success message
        return "Nurse added successfully ";
    }

    /**
     * Method to retrieve all nurses from the database
     * @return List<Nurse> - A list of all Nurse objects
     */
    public List<Nurse> getAllNurses() {
        // Converts the collection of Nurse objects (values of HashMap) to a List and returns it
        return nurseDb.values().stream().toList();
    }
}

