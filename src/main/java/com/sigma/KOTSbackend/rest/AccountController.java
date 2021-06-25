package com.sigma.KOTSbackend.rest;

import com.sigma.KOTSbackend.rest.DTO.ProfilRequest;
import com.sigma.KOTSbackend.rest.DTO.UserDTO;
import com.sigma.KOTSbackend.rest.DTO.UserRequest;
import com.sigma.KOTSbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/register")
    public void register(@RequestBody(required = true) UserRequest request){
     this.accountService.registerUser(request);
    }

    @GetMapping("/user")
    public UserDTO getUser(Principal principal){
        return this.accountService.getUser(principal.getName());
    }

    @PutMapping("/password")
    public boolean getPassword(@RequestBody(required = true) UserRequest request){

        return this.accountService.changePassword(request.getUsername(), request.getPassword());
    }

    @PutMapping("/update")
    public void update(Principal principal, @RequestBody(required = true) ProfilRequest request){
       this.accountService.updateProfil(principal.getName(),request);
    }

    @GetMapping("/username/{idUser}")
    public String getUsername(@PathVariable int idUser){
        return this.accountService.getUsername(idUser);
    }

    @GetMapping("/roles")
    public List<GrantedAuthority> getRoleAdmin(){
        List<GrantedAuthority> listAuthorities = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            listAuthorities.addAll(authentication.getAuthorities());
        }
        return listAuthorities;
    }
}