package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
