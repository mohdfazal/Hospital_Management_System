//package com.example.Hospital.Management.Controllers;
//
//import com.example.Hospital.Management.Models.Nurse;
//import com.example.Hospital.Management.Services.NurseService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/Nurse")
//public class NurseController {
//    NurseService nurseService = new NurseService();
//    @PostMapping("/add")
//    public String addNurse(@RequestBody Nurse nurse){
//        String ans = nurseService.addNurse(nurse);
//        return ans;
//    }
//
//    @GetMapping("/getByAge")
//    public List<Nurse> getAllNursesGreaterThanAge(@RequestParam("age") Integer age){
//        List<Nurse> nurseListByAge = nurseService.getList(age);
//        return nurseListByAge;
//    }
//
//    @GetMapping("/getByQualification")
//    public List<Nurse> getNurseByQualification(@RequestParam("qualification") String qualification){
//        List<Nurse> nurseListByQualification = nurseService.getListByQualification(qualification);
//        return nurseListByQualification;
//    }
//}
package com.example.Hospital.Management.Controllers;

// Import required classes
import com.example.Hospital.Management.Models.Nurse; // Importing Nurse model
import com.example.Hospital.Management.Services.NurseService; // Importing Nurse service
import org.springframework.web.bind.annotation.*;

import java.util.List; // Importing List for handling collections of nurses

// Marks this class as a REST Controller
@RestController
// Maps all endpoints in this class under the "/Nurse" base URL
@RequestMapping("/Nurse")
public class NurseController {

    // Creating an instance of NurseService to handle business logic
    NurseService nurseService = new NurseService();

    /**
     * Handles the POST request to add a new nurse.
     * @param nurse - The nurse object received in the request body.
     * @return A string message indicating success.
     */
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse) {
        // Calls the addNurse method in NurseService and returns the result
        String ans = nurseService.addNurse(nurse);
        return ans;
    }

    /**
     * Handles the GET request to retrieve all nurses older than a specific age.
     * @param age - The age filter provided as a query parameter.
     * @return A list of Nurse objects that satisfy the age condition.
     */
    @GetMapping("/getByAge")
    public List<Nurse> getAllNursesGreaterThanAge(@RequestParam("age") Integer age) {
        // Calls getList in NurseService to fetch nurses by age
        List<Nurse> nurseListByAge = nurseService.getList(age);
        return nurseListByAge;
    }

    /**
     * Handles the GET request to retrieve nurses based on their qualification.
     * @param qualification - The qualification filter provided as a query parameter.
     * @return A list of Nurse objects matching the qualification.
     */
    @GetMapping("/getByQualification")
    public List<Nurse> getNurseByQualification(@RequestParam("qualification") String qualification) {
        // Calls getListByQualification in NurseService to fetch nurses by qualification
        List<Nurse> nurseListByQualification = nurseService.getListByQualification(qualification);
        return nurseListByQualification;
    }
}



















