package com.example.testCRUD.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Entity
@Table(name = "employees")
@Data
public class EmployeeEntity {

    @Id
    @Column(name = "employeeNumber")
    private String employeeNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


}
