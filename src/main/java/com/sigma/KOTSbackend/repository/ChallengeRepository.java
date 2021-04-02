package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Integer> {
}
