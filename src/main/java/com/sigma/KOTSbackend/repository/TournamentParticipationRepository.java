package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.TournamentParticipationEntity;
import com.sigma.KOTSbackend.domain.TournamentParticipationEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentParticipationRepository  extends JpaRepository<TournamentParticipationEntity, TournamentParticipationEntityPK> {

    List<TournamentParticipationEntity> findAllByIdtournament(int idtournament);
}
