package com.niloy.test.dao;

import com.niloy.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
