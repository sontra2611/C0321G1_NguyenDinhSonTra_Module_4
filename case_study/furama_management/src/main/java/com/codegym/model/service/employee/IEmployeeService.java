package com.codegym.model.service.employee;

import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(Integer id);

    void removeById(Integer id);

    Page<Employee> searchByName(Pageable pageable, String name);
}
