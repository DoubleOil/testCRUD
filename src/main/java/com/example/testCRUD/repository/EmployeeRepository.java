package com.example.testCRUD.repository;


import com.example.testCRUD.entity.EmployeeEntity;
import com.example.testCRUD.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {

}
