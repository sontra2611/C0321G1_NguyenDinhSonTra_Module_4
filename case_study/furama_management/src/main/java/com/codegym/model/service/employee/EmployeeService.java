package com.codegym.model.service.employee;

import com.codegym.model.entity.employee.Employee;
import com.codegym.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> searchByName(Pageable pageable, String name) {
        return iEmployeeRepository.findAllByEmployeeNameContaining(pageable, name);
    }
}
