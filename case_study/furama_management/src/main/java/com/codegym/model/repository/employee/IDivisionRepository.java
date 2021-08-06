package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
