package com.umusada.repo.umusada;

import com.umusada.entity.umusada.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}