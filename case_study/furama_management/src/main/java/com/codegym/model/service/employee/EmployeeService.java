package com.codegym.model.service.employee;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.repository.employee.IDivisionRepository;
import com.codegym.model.repository.employee.IEducationDegreeRepository;
import com.codegym.model.repository.employee.IEmployeeRepository;
import com.codegym.model.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IPositionRepository iPositionRepository;

    @Autowired
    IDivisionRepository iDivisionRepository;

    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
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

    @Override
    public List<Position> findAllPossition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return iEducationDegreeRepository.findAll();
    }
}
