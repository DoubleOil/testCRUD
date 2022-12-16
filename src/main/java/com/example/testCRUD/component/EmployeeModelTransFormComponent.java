package com.example.testCRUD.component;


import com.example.testCRUD.entity.EmployeeEntity;
import com.example.testCRUD.model.EmployeeModel;
import com.example.testCRUD.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelTransFormComponent {

    public EmployeeModel TransFormEntityToModel(EmployeeEntity employeeEntity){
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setEmployeeNumber(employeeEntity.getEmployeeNumber());
        employeeModel.setFirstName(employeeEntity.getFirstName());
        employeeModel.setLastName(employeeEntity.getLastName());

        return employeeModel;

    }

    public EmployeeEntity TransFormModelToEntity(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmployeeNumber(employeeModel.getEmployeeNumber());
        employeeEntity.setFirstName(employeeModel.getFirstName());
        employeeEntity.setLastName(employeeModel.getLastName());

        return employeeEntity;
    }

}
