
package com.sigma.KOTSbackend.repository;

import com.sigma.KOTSbackend.domain.ChallengeParticipationEntity;
import com.sigma.KOTSbackend.domain.ChallengeParticipationEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChallengeParticipationRepository extends JpaRepository<ChallengeParticipationEntity, ChallengeParticipationEntityPK> {

    List<ChallengeParticipationEntity> findAllByIdchallenge(int idchallenge);
}
