package com.hdbfs.sales;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {

    Map<Integer,Emp> database = new HashMap<>();

    @PostMapping("/save")
    public Emp save(@RequestBody Emp emp){
        emp.setEmpNo(UUID.randomUUID().hashCode());
        database.put(emp.getEmpNo(),emp);
        return emp;
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<Emp> update(@RequestBody Emp emp){
        if(emp.getEmpNo() == 0){
            throw new RuntimeException("No employee found");
        }
        int empNo = emp.getEmpNo();
        database.put(empNo,emp);
        return ResponseEntity.ok(emp);
    }


    @GetMapping("/get-all-employees")
    public Collection<Emp> getAllEmployees(){
       return  database.values();
    }


}
