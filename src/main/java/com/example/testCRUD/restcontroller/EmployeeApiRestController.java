package com.example.testCRUD.restcontroller;


import com.example.testCRUD.entity.EmployeeEntity;
import com.example.testCRUD.model.EmployeeModel;
import com.example.testCRUD.model.ResponseModel;
import com.example.testCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class EmployeeApiRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<EmployeeEntity> list() {
        return employeeService.listAll();

    }

    @GetMapping("/employee/{number}")
    public ResponseModel<EmployeeModel> getEmployeeByNumber(@PathVariable(name = "number") String number){
        return employeeService.getEmployeeByNumber(number);
    }

    @PostMapping("/employee/add")
    public void add(@RequestBody EmployeeEntity employeeEntity){
        employeeService.save(employeeEntity);
    }

    @PutMapping("/employee/update/{number}")
    public EmployeeEntity update(@RequestBody EmployeeEntity employeeEntity,@PathVariable String number) {
        employeeEntity.setEmployeeNumber(number);
        employeeService.update(employeeEntity);
        return employeeEntity;
    }

    @DeleteMapping("/employee/delete/{number}")
    public void delete(@PathVariable String number){
        employeeService.delete(number);
    }

}
