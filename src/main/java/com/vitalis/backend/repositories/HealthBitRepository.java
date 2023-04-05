package com.vitalis.backend.repositories;

import com.vitalis.backend.entities.HealthBit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthBitRepository extends JpaRepository<HealthBit, Long> {

    Page<HealthBit> findAll(Pageable pageable);

    Page<HealthBit> findByCategory(String category, Pageable pageable);

    HealthBit save(HealthBit healthBit);

}


