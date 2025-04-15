package com.umusada.repo;

import com.umusada.entity.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
}