package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.TournamentEntity;
import com.sigma.KOTSbackend.repository.ChallengeRepository;
import com.sigma.KOTSbackend.repository.TournamentRepository;
import com.sigma.KOTSbackend.rest.DTO.ChallengeRequest;
import com.sigma.KOTSbackend.rest.DTO.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private TournamentRepository tournamentRepository;
    private ChallengeRepository challengeRepository;

    @Autowired
    public EventService(TournamentRepository tournamentRepository, ChallengeRepository challengeRepository) {
        this.tournamentRepository = tournamentRepository;
        this.challengeRepository = challengeRepository;
    }


    public void createTournament(TournamentRequest request) {
        TournamentEntity newTournament = new TournamentEntity(request.getSpecificity(), request.getDescription(), request.getConditions(), request.getIdUser());
        this.tournamentRepository.save(newTournament);
    }

    public void createChallenge(ChallengeRequest request) {
        ChallengeEntity newChallenge = new ChallengeEntity(request.getSpecificity(), request.getDescription(), request.getConditions(), request.getIdUser());
        this.challengeRepository.save(newChallenge);
    }

    public List<TournamentEntity> getTournament() {
        return this.tournamentRepository.findAll();
    }

    public List<ChallengeEntity> getChallenge() {
        return this.challengeRepository.findAll();
    }

    public void registerTournament(int tournamentId, int userId) {
        TournamentEntity tournament = this.tournamentRepository.findById(tournamentId).get();
        tournament.setIdUser(userId);
        this.tournamentRepository.save(tournament);
    }

    public void registerChallenge(int challengeId, int userId) {
        ChallengeEntity challenge = this.challengeRepository.findById(challengeId).get();
        challenge.setIdUser(userId);
        this.challengeRepository.save(challenge);
    }
}
