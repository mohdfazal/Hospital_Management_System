package com.example.Hospital.Management;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        //write business logic
        //validation
        if (nurse.getNurseId() < 0){
            return "Enter a valid nurseId";
        }
        if (nurse.getName().equals(null)){
            return "Name cannot be null";
        }
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getList(int age){
        List<Nurse> nurses = nurseRepository.getAllNurses();

        List<Nurse> finalList = new ArrayList<>();
        for(Nurse nurse : nurses){
            if (nurse.getAge() > age){
                finalList.add(nurse);
            }
        }
        return finalList;
    }

    public List<Nurse> getListByQualification(String qualification){
        List<Nurse> getAllNurses = nurseRepository.getAllNurses();

        List<Nurse> finalNurseListByQualification = new ArrayList<>();
        for(Nurse nurse : getAllNurses){
            if(nurse.getQualification().equals(qualification)){
                finalNurseListByQualification.add(nurse);
            }
        }

        return finalNurseListByQualification;
    }
}
