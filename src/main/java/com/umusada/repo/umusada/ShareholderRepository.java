package com.umusada.repo.umusada;

import com.umusada.entity.umusada.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
}