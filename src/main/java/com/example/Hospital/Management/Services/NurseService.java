//package com.example.Hospital.Management.Services;
//
//import com.example.Hospital.Management.Models.Nurse;
//import com.example.Hospital.Management.Repositories.NurseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class NurseService {
////    NurseRepository nurseRepository = new NurseRepository();
////    we don't need to create object manually we can autowired it
//    @Autowired
//    NurseRepository nurseRepository;
//
//    public String addNurse(Nurse nurse){
//        //write business logic
//        //validation
//        if (nurse.getNurseId() < 0){
//            return "Enter a valid nurseId";
//        }
//        if (nurse.getName().equals(null)){
//            return "Name cannot be null";
//        }
//        String ans = nurseRepository.addNurse(nurse);
//        return ans;
//    }
//
//    public List<Nurse> getList(int age){
//        List<Nurse> nurses = nurseRepository.getAllNurses();
//
//        List<Nurse> finalList = new ArrayList<>();
//        for(Nurse nurse : nurses){
//            if (nurse.getAge() > age){
//                finalList.add(nurse);
//            }
//        }
//        return finalList;
//    }
//
//    public List<Nurse> getListByQualification(String qualification){
//        List<Nurse> getAllNurses = nurseRepository.getAllNurses();
//
//        List<Nurse> finalNurseListByQualification = new ArrayList<>();
//        for(Nurse nurse : getAllNurses){
//            if(nurse.getQualification().equals(qualification)){
//                finalNurseListByQualification.add(nurse);
//            }
//        }
//
//        return finalNurseListByQualification;
//    }
//}

package com.example.Hospital.Management.Services;

// Import necessary packages
import com.example.Hospital.Management.Models.Nurse; // Nurse model
import com.example.Hospital.Management.Repositories.NurseRepository; // Nurse repository for database interaction
import org.springframework.beans.factory.annotation.Autowired; // Autowired annotation for dependency injection
import org.springframework.stereotype.Service; // Service annotation for business logic

import java.util.ArrayList; // Used for creating new lists
import java.util.List; // List interface

// Marks this class as a service layer in the Spring framework
@Service
public class NurseService {

    // Automatically inject the NurseRepository dependency
    @Autowired
    NurseRepository nurseRepository;

    /**
     * Adds a new nurse after validating the input.
     * @param nurse - The Nurse object to be added.
     * @return A success or error message based on the validation.
     */
    public String addNurse(Nurse nurse) {
        // Business logic: Validate nurseId
        if (nurse.getNurseId() < 0) {
            return "Enter a valid nurseId"; // Error if nurseId is invalid
        }
        // Business logic: Validate name
        if (nurse.getName().equals(null)) {
            return "Name cannot be null"; // Error if name is null
        }
        // Delegate the task of adding a nurse to the repository
        String ans = nurseRepository.addNurse(nurse);
        return ans; // Return success message from the repository
    }

    /**
     * Retrieves a list of nurses older than the specified age.
     * @param age - The age to filter nurses by.
     * @return A list of Nurse objects above the specified age.
     */
    public List<Nurse> getList(int age) {
        // Fetch all nurses from the repository
        List<Nurse> nurses = nurseRepository.getAllNurses();

        // Create a new list to store nurses that meet the age condition
        List<Nurse> finalList = new ArrayList<>();
        for (Nurse nurse : nurses) { // Iterate through each nurse
            if (nurse.getAge() > age) { // Check if the nurse's age is greater than the specified age
                finalList.add(nurse); // Add the nurse to the final list
            }
        }
        return finalList; // Return the filtered list
    }

    /**
     * Retrieves a list of nurses based on their qualification.
     * @param qualification - The qualification to filter nurses by.
     * @return A list of Nurse objects with the specified qualification.
     */
    public List<Nurse> getListByQualification(String qualification) {
        // Fetch all nurses from the repository
        List<Nurse> getAllNurses = nurseRepository.getAllNurses();

        // Create a new list to store nurses that meet the qualification condition
        List<Nurse> finalNurseListByQualification = new ArrayList<>();
        for (Nurse nurse : getAllNurses) { // Iterate through each nurse
            if (nurse.getQualification().equals(qualification)) { // Check if the nurse's qualification matches
                finalNurseListByQualification.add(nurse); // Add the nurse to the final list
            }
        }
        return finalNurseListByQualification; // Return the filtered list
    }
}
