package com.employee.controller;

import com.employee.domain.Employee;
import com.employee.service.CustomerErrorGenerator;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nick on 1/9/2020.
 */
@RestController
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerErrorGenerator customerErrorGenerator;

    @PostMapping(value = "")
      public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee,BindingResult result){
      if(customerErrorGenerator.getErrors(result)==null){
          return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
      }else{
          return new CustomerErrorGenerator().getErrors(result);
      }

    }
    @GetMapping(value = "")
    public ResponseEntity<?> GetAllEmployee(){

        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> GetById(@PathVariable String id){

        return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){

        return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> UpdateEmployee(@PathVariable String id,@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/activate")
    public ResponseEntity<?> activateEmployee(@PathVariable String id){
        return new ResponseEntity<Employee>(employeeService.activateEmployee(id), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/suspend")
    public ResponseEntity<?> suspendEmployee(@PathVariable String id){
        return new ResponseEntity<Employee>(employeeService.suspendEmployee(id), HttpStatus.CREATED);
    }
    @GetMapping(value = "/search/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<Employee>(employeeService.findAny(name), HttpStatus.CREATED);
    }
    @GetMapping(value = "/search/phone/{phone}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String phone){
        return new ResponseEntity<Employee>(employeeService.findByPhoneNumber(phone), HttpStatus.CREATED);
    }
    @GetMapping(value = "/search/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        return new ResponseEntity<Employee>(employeeService.findByEmail(email), HttpStatus.CREATED);
    }
    @GetMapping(value = "/search/position/{position}")
    public ResponseEntity<?> findByPosition(@PathVariable String position){
        return new ResponseEntity<List<Employee>>(employeeService.findByPosition(position), HttpStatus.CREATED);
    }

}
