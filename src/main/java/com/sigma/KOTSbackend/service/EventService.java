package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.domain.*;
import com.sigma.KOTSbackend.repository.*;
import com.sigma.KOTSbackend.rest.DTO.ChallengeRequest;
import com.sigma.KOTSbackend.rest.DTO.ParticipationRequest;
import com.sigma.KOTSbackend.rest.DTO.TournamentRequest;
import com.sigma.KOTSbackend.rest.DTO.ValidateRunRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private TournamentRepository tournamentRepository;
    private ChallengeRepository challengeRepository;
    private RunRepository runRepository;
    private ChallengeParticipationRepository challengeParticipationRepository;
    private TournamentParticipationRepository tournamentParticipationRepository;

    @Autowired
    public EventService(TournamentRepository tournamentRepository,ChallengeRepository challengeRepository, RunRepository runRepository,ChallengeParticipationRepository challengeParticipationRepository,TournamentParticipationRepository tournamentParticipationRepository) {
        this.tournamentRepository = tournamentRepository;
        this.challengeRepository = challengeRepository;
        this.runRepository = runRepository;
        this.challengeParticipationRepository = challengeParticipationRepository;
        this.tournamentParticipationRepository = tournamentParticipationRepository;
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


    public void registerParticipationChallenge(ParticipationRequest request){
        System.out.println("id Challenge: "+request.getIdEvent());
        RunEntity newRun = new RunEntity(10,request.getVideoid(),request.getIdUser());
        // newRun.setIdUser(request.getIdUser());
        // prendre le timer string et le convertir en int 00:00:00 / 3600:60:00
        // newRun.setTimer(10);
        // newRun.setVideoid(request.getVideoid());
        this.runRepository.save(newRun);

        System.out.println("runId = "+newRun.getId());
        System.out.println("localDate = "+LocalDate.now());
        ChallengeParticipationEntity participation = new ChallengeParticipationEntity(newRun.getId(), request.getIdEvent(),"waiting","create at "+LocalDate.now());
        this.challengeParticipationRepository.save(participation);
    }

    public void registerParticipationTournament(ParticipationRequest request){
        System.out.println("id Challenge: "+request.getIdEvent());
        RunEntity newRun = new RunEntity(15,request.getVideoid(),request.getIdUser());
        // newRun.setIdUser(request.getIdUser());
        // prendre le timer string et le convertir en int 00:00:00 / 3600:60:00
        // newRun.setTimer(10);
        // newRun.setVideoid(request.getVideoid());
        this.runRepository.save(newRun);

        System.out.println("runId = "+newRun.getId());
        System.out.println("localDate = "+LocalDate.now());
        TournamentParticipationEntity participation = new TournamentParticipationEntity(newRun.getId(), request.getIdEvent(),"waiting","create at "+LocalDate.now());
        this.tournamentParticipationRepository.save(participation);
    }


    public List<RunEntity> getParticipationTournament(int idTournament) {
        List<TournamentParticipationEntity> participations = this.tournamentParticipationRepository.findAllByIdtournament(idTournament);
        List<RunEntity> runs = null;
        for( TournamentParticipationEntity participation : participations ) {
            runs.add(this.runRepository.findById(participation.getIdrun()).get());

        }
       return runs;
    }

    public List<RunEntity> getParticipationChallenge(int idChallenge) {
        List<ChallengeParticipationEntity> participations = this.challengeParticipationRepository.findAllByIdchallenge(idChallenge);
        List<RunEntity> runs = new ArrayList<>();
        for( ChallengeParticipationEntity participation : participations ) {
            runs.add(this.runRepository.findById(participation.getIdrun()).get());

        }
        return runs;
    }


    public void validateRun(ValidateRunRequest request) {
        /*PlayerEntityPK playerId = new PlayerEntityPK(request.getIdUser(),request.getIdEvent());
        PlayerEntity player = this.playerRepository.getOne(playerId);
        player.setApproved(request.isValidation());
        this.playerRepository.save(player);*/
    }
}
