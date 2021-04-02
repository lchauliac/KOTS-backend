package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TournamentRepository extends JpaRepository<TournamentEntity, Integer> {
}


