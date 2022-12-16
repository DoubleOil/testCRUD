package com.example.testCRUD.service;


import com.example.testCRUD.component.EmployeeModelTransFormComponent;
import com.example.testCRUD.entity.EmployeeEntity;
import com.example.testCRUD.model.EmployeeModel;
import com.example.testCRUD.model.ResponseModel;
import com.example.testCRUD.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j //บอก lombok ในการสร้าง log
public class EmployeeService {

    private static EmployeeRepository employeeRepository; //คือการAutowide class EmployeeRepository มาใช้งาน
    private EmployeeModelTransFormComponent employeeModelTransFormComponent;


    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeModelTransFormComponent employeeModelTransFormComponent) {
        this.employeeModelTransFormComponent = employeeModelTransFormComponent;
        this.employeeRepository = employeeRepository;
    }


    public List<EmployeeEntity> listAll() {

        return employeeRepository.findAll();
    }

    public ResponseModel<EmployeeModel> getEmployeeByNumber(String number) {
        ResponseModel result = new ResponseModel<>();
        result.setStatus(404);
        result.setDescription("employee not found");

        log.info("getEmployeeByNumber {}", number);

        try {
            Optional<EmployeeEntity> optionalEmployee = this.employeeRepository.findById(number);

            if (optionalEmployee.isPresent()) {
                EmployeeEntity employeeEntity = optionalEmployee.get();
                EmployeeModel data = this.employeeModelTransFormComponent.TransFormEntityToModel(employeeEntity);
                result.setData(data);
                result.setStatus(200);
                result.setDescription("");
            }

        } catch (Exception e) {
            log.info("getEmployeeByNumber {}", e.getMessage());
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    public void save(EmployeeEntity employeeEntity) {

        employeeRepository.save(employeeEntity);
    }

    public void update(EmployeeEntity employeeEntity ){
        employeeRepository.save(employeeEntity);

    }
    public void delete(String number) {

        employeeRepository.deleteById(number);
    }



}



