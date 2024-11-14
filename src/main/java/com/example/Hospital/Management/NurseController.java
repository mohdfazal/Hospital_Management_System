package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Nurse")
public class NurseController {
    NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){
        String ans = nurseService.addNurse(nurse);
        return ans;
    }

    @GetMapping("/getByAge")
    public List<Nurse> getAllNursesGreaterThanAge(@RequestParam("age") Integer age){
        List<Nurse> nurseListByAge = nurseService.getList(age);
        return nurseListByAge;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNurseByQualification(@RequestParam("qualification") String qualification){
        List<Nurse> nurseListByQualification = nurseService.getListByQualification(qualification);
        return nurseListByQualification;
    }
}
