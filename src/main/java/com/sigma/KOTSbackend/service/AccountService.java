package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.repository.AccountRepository;
import com.sigma.KOTSbackend.domain.UserEntity;
import com.sigma.KOTSbackend.rest.DTO.ProfilRequest;
import com.sigma.KOTSbackend.rest.DTO.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.security.Security;
import java.util.List;

@Service
public class AccountService {

    private final BCryptPasswordEncoder newPassword;
    private final AccountRepository accountRepository;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    public AccountService(BCryptPasswordEncoder newPassword,AccountRepository accountRepository,JdbcUserDetailsManager jdbcUserDetailsManager){
        this.newPassword = newPassword;
        this.accountRepository = accountRepository;
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
    }

    public void registerUser(UserRequest request){
        UserDetails userDetails = new User(request.getUsername(),newPassword.encode(request.getPassword()), List.of(new SimpleGrantedAuthority("USER")));
        this.jdbcUserDetailsManager.createUser(userDetails);

        UserEntity user=new UserEntity(request.getUsername(),request.getMail(),null,null,null);
        this.accountRepository.save(user);
    }


    public UserEntity getUser(String username){
        return this.accountRepository.findByUsername(username);
    }

    public void updateProfil(String username, ProfilRequest request) {
        UserEntity user = this.accountRepository.findByUsername(username);
        user.setDescription(request.getDescription());
        user.setMail(request.getMail());
        System.out.println("twitch: "+request.getTwitch());
        System.out.println("youtube: "+request.getYoutube());
        user.setTwitch(request.getTwitch());
        user.setYoutube(request.getYoutube());
         this.accountRepository.save(user);
    }

    public boolean changePassword(String username,String newPassword) {
        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(username);
        String password = this.newPassword.encode(newPassword);
        System.out.println("password / currentPassword : "+password+" | "+currentUser.getPassword());
        if (this.newPassword.matches(newPassword, currentUser.getPassword())) {
            System.out.println("error existe déjà : " + newPassword);
            return false;
        }
        else {
            this.jdbcUserDetailsManager.changePassword(currentUser.getPassword(), password);
            return true;
        }
        /*
        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(username);
        if (this.newPassword.matches(newPassword, currentUser.getPassword())){
            System.out.println("error existe déjà : " + newPassword);
        return false;
    } else{
            String password = this.newPassword.encode(newPassword);
        UserDetails userDetails = new User(username,password , List.of(new SimpleGrantedAuthority("USER")));

            System.out.println("password : "+newPassword);
            System.out.println("password : "+password);
            System.out.println("password : "+currentUser.getPassword());
            System.out.println();
        this.jdbcUserDetailsManager.changePassword(currentUser.getPassword(),password);
            this.jdbcUserDetailsManager.setChangePasswordSql(password);
        this.jdbcUserDetailsManager.updateUser(currentUser);
       // this.jdbcUserDetailsManager.updateUser(userDetails);
        currentUser=this.jdbcUserDetailsManager.loadUserByUsername(username);
        System.out.println("password : "+newPassword);
        System.out.println("password : "+password);
        System.out.println("password : "+currentUser.getPassword());


        return true;
        }*/
    }
}
