package com.sigma.KOTSbackend.rest;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.PlayerEntity;
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

    @PutMapping("/tournament/register")
    public void registerTournament(@RequestBody(required = true) EventRequest request) {
        this.eventService.registerTournament(request.getIdEvent(),request.getIdUser());
    }

    @PutMapping("/challenge/register")
    public void registerChallenge(@RequestBody(required = true) EventRequest request) {
        this.eventService.registerChallenge(request.getIdEvent(),request.getIdUser());
    }

    @PostMapping("/player/challenge/register")
    public void registerPlayerChallenge(@RequestBody(required = true) PlayerRequest request){
        System.out.println("id Challenge Controller: "+request.getIdEvent());
        this.eventService.registerPlayerChallenge(request);
    }

    @GetMapping("/player/challenge/get/{idChallenge}")
    public List<PlayerEntity> getChallengePlayers(@PathVariable int idChallenge){
        return this.eventService.getPlayers(idChallenge);
    }

    @PutMapping("/challenge/validate")
    public void validateRun(@RequestBody(required = true)ValidateRunRequest request){
        this.eventService.validateRun(request);
    }
}
