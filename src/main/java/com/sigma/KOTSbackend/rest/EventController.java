package com.sigma.KOTSbackend.rest;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.ChallengeParticipationEntity;
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

    @GetMapping("/participate/tournament/get{idTournament}")
    public List<RunEntity> getParticipationTournament(@PathVariable int idTournament){
        return this.eventService.getParticipationTournament(idTournament);
    }

    @GetMapping("/participate/challenge/get/{idChallenge}")
    public List<RunEntity> getParticipationChallenge(@PathVariable int idChallenge){
        return this.eventService.getParticipationChallenge(idChallenge);
    }

    @PutMapping("/challenge/validate")
    public void validateRun(@RequestBody(required = true)ValidateRunRequest request){
        this.eventService.validateRun(request);
    }
}
