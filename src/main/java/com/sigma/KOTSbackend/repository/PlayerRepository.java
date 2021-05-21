package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.PlayerEntity;
import com.sigma.KOTSbackend.domain.PlayerEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, PlayerEntityPK> {

    List<PlayerEntity> findAllByIdchallenge(int idchallenge);
}
