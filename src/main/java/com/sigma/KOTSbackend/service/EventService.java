package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.PlayerEntity;
import com.sigma.KOTSbackend.domain.PlayerEntityPK;
import com.sigma.KOTSbackend.domain.TournamentEntity;
import com.sigma.KOTSbackend.repository.ChallengeRepository;
import com.sigma.KOTSbackend.repository.PlayerRepository;
import com.sigma.KOTSbackend.repository.TournamentRepository;
import com.sigma.KOTSbackend.rest.DTO.ChallengeRequest;
import com.sigma.KOTSbackend.rest.DTO.PlayerRequest;
import com.sigma.KOTSbackend.rest.DTO.TournamentRequest;
import com.sigma.KOTSbackend.rest.DTO.ValidateRunRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private TournamentRepository tournamentRepository;
    private ChallengeRepository challengeRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public EventService(TournamentRepository tournamentRepository, ChallengeRepository challengeRepository, PlayerRepository playerRepository) {
        this.tournamentRepository = tournamentRepository;
        this.challengeRepository = challengeRepository;
        this.playerRepository = playerRepository;
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

    public List<PlayerEntity> getPlayers(int idchallenge){
        return this.playerRepository.findAllByIdchallenge(idchallenge);
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

    public void registerPlayerChallenge(PlayerRequest request){
        System.out.println("id Challenge: "+request.getIdEvent());
        PlayerEntity player = new PlayerEntity(request.getIdUser(),request.getIdEvent(), request.getTimer(), request.getUrl_youtube());
        this.playerRepository.save(player);
    }

    public void validateRun(ValidateRunRequest request) {
        PlayerEntityPK playerId = new PlayerEntityPK(request.getIdUser(),request.getIdEvent());
        PlayerEntity player = this.playerRepository.getOne(playerId);
        player.setApproved(request.isValidation());
        this.playerRepository.save(player);
    }
}
