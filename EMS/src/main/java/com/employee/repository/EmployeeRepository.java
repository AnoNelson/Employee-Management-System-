package com.employee.repository;

import com.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nick on 1/9/2020.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    Employee findByNationalId(String id);
    Employee findByEmployeeName(String name);
    Employee findByPhoneNumber(String number);
    Employee findByEmail(String email);
    List<Employee> findByPosition(String position);

}
