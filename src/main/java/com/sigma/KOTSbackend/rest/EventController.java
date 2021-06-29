package com.sigma.KOTSbackend.rest;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.RunEntity;
import com.sigma.KOTSbackend.domain.TournamentEntity;
import com.sigma.KOTSbackend.rest.DTO.*;
import com.sigma.KOTSbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/tournament/create")
    public void createTournament(@RequestBody(required = true) TournamentRequest request) {
        this.eventService.createTournament(request);
    }

    @PostMapping("/challenge/create")
    public void createChallenge(@RequestBody(required = true) ChallengeRequest request) {
        this.eventService.createChallenge(request);
    }

    @GetMapping("/tournament/get")
    public List<TournamentEntity> getAllTournament() {
        return this.eventService.getTournament();
    }
    @GetMapping("/challenge/get")
    public List<ChallengeEntity> getAllChallenge() {
        return this.eventService.getChallenge();
    }

    @PostMapping("/participate/tournament")
    public void registerParticipationTournament(@RequestBody(required = true) ParticipationRequest request){
        this.eventService.registerParticipationTournament(request);
    }

    @PostMapping("/participate/challenge")
    public void registerParticipationChallenge(@RequestBody(required = true) ParticipationRequest request){
        this.eventService.registerParticipationChallenge(request);
    }

/*    @GetMapping("/participate/tournament/get/{idTournament}")
    public RunDTO getParticipationTournament(@PathVariable int idTournament, @PathVariable int idUser){
        return this.eventService.getParticipationTournament(idTournament,idUser);
    }

    @GetMapping("/participate/challenge/get/{idChallenge}")
    public RunDTO getParticipationChallenge(@PathVariable int idChallenge, @PathVariable int idUser){
        return this.eventService.getParticipationChallenge(idChallenge,idUser);
    }*/

    @GetMapping("/participate/tournament/get/{idTournament}")
    public List<RunDTO> getParticipationsTournament(@PathVariable int idTournament){
        return this.eventService.getParticipationsTournament(idTournament);
    }

    @GetMapping("/participate/challenge/get/{idChallenge}")
    public List<RunDTO> getParticipationsChallenge(@PathVariable int idChallenge){
        return this.eventService.getParticipationsChallenge(idChallenge);
    }

    @PutMapping("/participate/tournament/validate")
    public void validateParticipationTournaments(@RequestBody(required = true)ValidateParticipationRequest request){
        this.eventService.validateParticipationTournament(request);
    }

    @PutMapping("/participate/challenge/validate")
    public void validateParticipationChallenge(@RequestBody(required = true)ValidateParticipationRequest request){
        this.eventService.validateParticipationChallenge(request);
    }

    @GetMapping("/participate/tournament/state/get/{idRun}/{idTournament}")
    public State getStateParticipationTournament(@PathVariable int idRun,@PathVariable int idTournament){
        return this.eventService.getStateParticipationTournament(idRun,idTournament);
    }

    @GetMapping("/participate/challenge/state/get/{idRun}/{idChallenge}")
    public State getStateParticipationChallenge(@PathVariable int idRun,@PathVariable int idChallenge){
        return this.eventService.getStateParticipationChallenge(idRun,idChallenge);
    }

}
