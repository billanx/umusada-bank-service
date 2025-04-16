package com.umusada.repo.bank;

import com.umusada.entity.bank.BusinessRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRequestRepository extends JpaRepository<BusinessRequestEntity, String> {
}
