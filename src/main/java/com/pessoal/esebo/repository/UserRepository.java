package com.pessoal.esebo.repository;

import com.pessoal.esebo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
