package com.employee.service;

import com.employee.domain.EStatus;
import com.employee.domain.Employee;
import com.employee.exceptions.GlobalException;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Nick on 1/9/2020.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        if((new Date().getYear()+1900) - (employee.getDateOfBirth().getYear()+1900)>=18 ){
            if(employee.getPhoneNumber().startsWith("+2507")){
                return employeeRepository.save(employee);
            }else{
                throw new GlobalException("Rwandan phone number must start with +250 and follow by 7");
            }
        }else{
            throw  new GlobalException("you are under 18 years old");
        }
    }
    public String deleteEmployee(String id){

        Employee employee = employeeRepository.findByNationalId(id);
        if(employee !=null){
            employeeRepository.delete(employee);
            return employee.getEmployeeName()+" has been deleted";
        }else{
            throw new GlobalException("the employee with "+id+" doesn't exis");
        }

    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Employee findById(String id){
       if(employeeRepository.findByNationalId(id) != null){
           return employeeRepository.findByNationalId(id);
       }else{
           throw new GlobalException("the employee with "+id+" doesn't exis");
       }

    }
    public Employee updateEmployee(String id,Employee employee){
        Employee employe = employeeRepository.findByNationalId(id);
        if(employe !=null && employee.getNationalId().equals(id)){
            employe = employee;
            return employeeRepository.save(employe);
        }else {
            throw new GlobalException("the id you provided "+id +"doesn't match the employee you are saving ");
        }

    }
    public Employee findAny(String any){
        if( employeeRepository.findByEmployeeName(any) != null){
            return employeeRepository.findByEmployeeName(any);
        }else{
            throw new GlobalException("the employee with Name of "+any+" doesn't exist");
        }
        }
    public Employee findByPhoneNumber(String any){
        if( employeeRepository.findByPhoneNumber(any) != null){
            return employeeRepository.findByPhoneNumber(any);
        }else{
            throw new GlobalException("the employee with "+any+" phone number doesn't exist");
        }
    }
    public Employee findByEmail(String email){
        if( employeeRepository.findByEmail(email) != null){
            return employeeRepository.findByEmail(email);
        }else{
            throw new GlobalException("the employee with "+email+" phone number doesn't exist");
        }
    }
    public List<Employee> findByPosition(String position){
        if( employeeRepository.findByPosition(position).size() == 0){
            throw new GlobalException("No employee found with "+position+" position ");
        }else{
            return employeeRepository.findByPosition(position);
        }

    }
    public Employee activateEmployee(String any){

        Employee employee = employeeRepository.findByNationalId(any);
        if(employee !=null){
            employee.setStatus(EStatus.active);
            return employeeRepository.save(employee);
        }else{
            throw new GlobalException("the employee with "+any+" doesn't exis");
        }

    }
    public Employee suspendEmployee(String any){
        Employee employee = employeeRepository.findByNationalId(any);
        if(employee !=null){
            employee.setStatus(EStatus.inactive);
            return employeeRepository.save(employee);
        }else{
            throw new GlobalException("the employee with "+any+" doesn't exis");
        }
    }

    }

