package com.example.WMS_Spring_Part1.Controller;

import com.example.WMS_Spring_Part1.model.Employee;
import com.example.WMS_Spring_Part1.model.LoginDTO;
import com.example.WMS_Spring_Part1.repository.UserRepository;
import com.example.WMS_Spring_Part1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController (UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users/getAllEmployee")
  public List<Employee> getAllEmployees(){return UserRepository.getAllEmployees();}

  @GetMapping(value = "/users/getAllAdmins")
  public List<Employee> getAllAdmins(){return UserRepository.getAllEmployees();}

  @GetMapping(value = "/users/employee/login")
  public boolean employeeLogin(@RequestBody LoginDTO loginDTO){
    return userService.employeeCredentialIsCorrect(loginDTO.getUsername(), loginDTO.getPassword());}


  @GetMapping(value = "/users/admin/login")
      public boolean adminLogin(@RequestBody LoginDTO loginDTO){
        return userService.employeeCredentialIsCorrect(loginDTO.getUsername(), loginDTO.getPassword());
      }

}
