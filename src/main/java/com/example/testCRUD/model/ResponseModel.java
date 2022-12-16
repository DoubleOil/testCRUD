package com.example.testCRUD.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseModel<E> {
    public  E data;
    public int Status;
    public String Description;

}
