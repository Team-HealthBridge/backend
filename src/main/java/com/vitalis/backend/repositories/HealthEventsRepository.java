package com.vitalis.backend.repositories;

import com.vitalis.backend.entities.HealthEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthEventsRepository extends JpaRepository<HealthEvent, Long> {
    @Query("SELECT h FROM HealthEvent h WHERE h.startDate <= ?1 AND h.endDate >= ?1")
    HealthEvent findByDate(String today);
}
