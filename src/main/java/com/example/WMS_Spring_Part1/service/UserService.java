package com.example.WMS_Spring_Part1.service;

import com.example.WMS_Spring_Part1.model.Admin;
import com.example.WMS_Spring_Part1.model.Employee;
import com.example.WMS_Spring_Part1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

//Annotate this class with @Service annotation as later we'll need to use this service class in our Controller.
@Service
public class UserService {

  //four new methods to get all the employees, get all the admins, if employee credential is correct and if admin credential is correct in this service class
  // and simply call the appropriate static methods from the UserRepository class.

  public List<Employee> getAllEmployees(){return UserRepository.getAllEmployees();}

  public List <Admin> getAllAdmins(){return UserRepository.getAllAdmins();}

  public boolean employeeCredentialIsCorrect(String name, String password){return UserRepository.isUserValid(name, password);}

  public boolean adminCredentialIsCorrect(String name, String password){return UserRepository.isUserValid(name, password);}



}
