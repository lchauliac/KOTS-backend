package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.domain.*;
import com.sigma.KOTSbackend.repository.*;
import com.sigma.KOTSbackend.rest.DTO.*;
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
    private UserRepository userRepository;

    @Autowired
    private DtoConverterService dtoConverterService;

    @Autowired
    public EventService(TournamentRepository tournamentRepository,ChallengeRepository challengeRepository, RunRepository runRepository,ChallengeParticipationRepository challengeParticipationRepository,TournamentParticipationRepository tournamentParticipationRepository, UserRepository userRepository) {
        this.tournamentRepository = tournamentRepository;
        this.challengeRepository = challengeRepository;
        this.runRepository = runRepository;
        this.challengeParticipationRepository = challengeParticipationRepository;
        this.tournamentParticipationRepository = tournamentParticipationRepository;
        this.userRepository = userRepository;
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
        RunEntity newRun = new RunEntity(10,request.getVideoid(),this.userRepository.getOne(request.getIdUser()));
        this.runRepository.save(newRun);

        ChallengeParticipationEntity participation = new ChallengeParticipationEntity(newRun.getId(), request.getIdEvent(),"waiting","create at "+LocalDate.now());
        this.challengeParticipationRepository.save(participation);
    }

    public void registerParticipationTournament(ParticipationRequest request){
        RunEntity newRun = new RunEntity(15,request.getVideoid(),this.userRepository.getOne(request.getIdUser()));
        this.runRepository.save(newRun);

        TournamentParticipationEntity participation = new TournamentParticipationEntity(newRun.getId(), request.getIdEvent(),"waiting","create at "+LocalDate.now());
        this.tournamentParticipationRepository.save(participation);
    }


    public List<RunDTO> getParticipationTournament(int idTournament) {
        List<TournamentParticipationEntity> participations = this.tournamentParticipationRepository.findAllByIdtournament(idTournament);
        List<RunEntity> runs = new ArrayList<>();
        for( TournamentParticipationEntity participation : participations ) {
            runs.add(this.runRepository.findById(participation.getIdrun()).get());

        }
       return this.dtoConverterService.mapAsList(runs, RunDTO.class);
    }

    public List<RunDTO> getParticipationChallenge(int idChallenge) {
        List<ChallengeParticipationEntity> participations = this.challengeParticipationRepository.findAllByIdchallenge(idChallenge);
        List<RunEntity> runs = new ArrayList<>();
        for( ChallengeParticipationEntity participation : participations ) {
            runs.add(this.runRepository.findById(participation.getIdrun()).get());

        }
        return this.dtoConverterService.mapAsList(runs, RunDTO.class);
    }


    public void validateParticipationTournament(ValidateParticipationRequest request){
        TournamentParticipationEntityPK participationId = new TournamentParticipationEntityPK(request.getIdRun(), request.getIdEvent());
        TournamentParticipationEntity participation = this.tournamentParticipationRepository.findById(participationId).get();
        participation.setState(request.getState());
        System.out.print("Run is "+request.getState());
        this.tournamentParticipationRepository.save(participation);
    }

    public void validateParticipationChallenge(ValidateParticipationRequest request) {
        System.out.println("idRun / idChall "+request.getIdRun()+" / "+request.getIdEvent());
        ChallengeParticipationEntityPK participationId = new ChallengeParticipationEntityPK(request.getIdRun(), request.getIdEvent());
        ChallengeParticipationEntity participation = this.challengeParticipationRepository.findById(participationId).get();
        participation.setState(request.getState());
        System.out.print("Run is "+request.getState());
        this.challengeParticipationRepository.save(participation);
    }

    public String getStateParticipationTournament(int idRun,int idTournament){
        TournamentParticipationEntityPK participationId = new TournamentParticipationEntityPK(idRun, idTournament);
        TournamentParticipationEntity participation = this.tournamentParticipationRepository.findById(participationId).get();
        return participation.getState();
    }

    public String getStateParticipationChallenge(int idRun,int idChallenge) {
        ChallengeParticipationEntityPK participationId = new ChallengeParticipationEntityPK(idRun, idChallenge);
        ChallengeParticipationEntity participation = this.challengeParticipationRepository.findById(participationId).get();
        return participation.getState();
    }


}
