package com.CrudOperation.fullstack_backend.repository;


import com.CrudOperation.fullstack_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<User, Long> {
}
