package com.vitalis.backend.repositories;

import com.vitalis.backend.entities.HealthBit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthBitRepository extends JpaRepository<HealthBit, Long> {
    @Query("SELECT h FROM HealthBit h")
    Page<HealthBit> findAll(Pageable pageable);
    @Query("SELECT h FROM HealthBit h WHERE h.category = :category")
    Page<HealthBit> findByCategory(String category, Pageable pageable);
    HealthBit save(HealthBit healthBit);

    @Query("SELECT DISTINCT h.category FROM HealthBit h")
    List<String> findDistinctCategories();

    @Query(value = "SELECT * FROM health_bits TABLESAMPLE BERNOULLI (10)", nativeQuery = true)
    Page<HealthBit> findRandom(Pageable pageRequest);

    @Query(value = "SELECT * FROM health_bits WHERE category = :category TABLESAMPLE BERNOULLI (10)", nativeQuery = true)
    Page<HealthBit> findRandomByCategory(String category, Pageable pageRequest);
}


