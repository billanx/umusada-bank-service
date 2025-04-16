package com.umusada.repo.umusada;

import com.umusada.entity.umusada.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}