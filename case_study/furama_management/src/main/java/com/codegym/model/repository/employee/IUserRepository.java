package com.codegym.model.repository.employee;

import com.codegym.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
    User findByUserName(String username);
}
