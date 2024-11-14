package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.HashMap;
//@RequestMapping("/doctor")
@RestController
public class DoctorController {
    HashMap<Integer, Doctor> doctorDb = new HashMap<>();
    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){
        int key = doctor.getDoctorId();
        doctorDb.put(key, doctor);
        return "Doctor has been added ";
    }

    @GetMapping("/getDoctor")
    public Doctor getDoctor(@RequestParam("doctorId") Integer doctorID){
        Doctor doctor = doctorDb.get(doctorID);
        return doctor;
    }
//    @GetMapping("/getDoctorViaRequestParam")
//    public Doctor getDoctorViaRequestParam(@RequestParam("doctorId") Integer doctorId){
//
//        return doctor;
//    }

}

