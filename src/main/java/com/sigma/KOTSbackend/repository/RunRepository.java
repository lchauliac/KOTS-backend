package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunRepository extends JpaRepository<RunEntity, Integer> {
}
