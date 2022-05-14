package com.hdbfs.sales;

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

    @GetMapping("/get-all-employees")
    public Collection<Emp> getAllEmployees(){
       return  database.values();
    }


}
