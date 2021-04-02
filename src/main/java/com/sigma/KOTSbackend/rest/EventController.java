package com.sigma.KOTSbackend.rest;

import com.sigma.KOTSbackend.domain.ChallengeEntity;
import com.sigma.KOTSbackend.domain.TournamentEntity;
import com.sigma.KOTSbackend.rest.DTO.ChallengeRequest;
import com.sigma.KOTSbackend.rest.DTO.EventRequest;
import com.sigma.KOTSbackend.rest.DTO.TournamentRequest;
import com.sigma.KOTSbackend.rest.model.Challenge;
import com.sigma.KOTSbackend.rest.model.Tournament;
import com.sigma.KOTSbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
}
