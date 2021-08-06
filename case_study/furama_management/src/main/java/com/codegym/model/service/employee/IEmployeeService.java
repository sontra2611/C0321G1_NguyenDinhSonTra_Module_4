package com.codegym.model.service.employee;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void removeById(Integer id);

    Page<Employee> searchByName(Pageable pageable, String name);

    List<Position> findAllPossition();

    List<Division> findAllDivision();

    List<EducationDegree> findAllEducationDegree();
}
