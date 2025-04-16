package com.umusada.repo.umusada;

import com.umusada.entity.umusada.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}