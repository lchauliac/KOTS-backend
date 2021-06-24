package com.sigma.KOTSbackend.service;

import com.sigma.KOTSbackend.repository.AccountRepository;
import com.sigma.KOTSbackend.domain.UserEntity;
import com.sigma.KOTSbackend.rest.DTO.ProfilRequest;
import com.sigma.KOTSbackend.rest.DTO.UserDTO;
import com.sigma.KOTSbackend.rest.DTO.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private BCryptPasswordEncoder newPassword;
    private AccountRepository accountRepository;
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private DtoConverterService dtoConverterService;

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


    public UserDTO getUser(String username){
        return this.dtoConverterService.map(this.accountRepository.findByUsername(username), UserDTO.class);
    }

    public void updateProfil(String username, ProfilRequest request) {
        UserEntity user = this.accountRepository.findByUsername(username);
        user.setDescription(request.getDescription());
        user.setMail(request.getMail());
        user.setTwitch(request.getTwitch());
        user.setYoutube(request.getYoutube());
         this.accountRepository.save(user);
    }

    public boolean changePassword(String username,String newPassword) {
        UserDetails currentUser = this.jdbcUserDetailsManager.loadUserByUsername(username);
        String password = this.newPassword.encode(newPassword);
        if (this.newPassword.matches(newPassword, currentUser.getPassword())) {
            System.out.println("error existe déjà : " + newPassword);
            return false;
        }
        else {
            this.jdbcUserDetailsManager.changePassword(currentUser.getPassword(), password);
            return true;
        }
    }

    public String getUsername(int idUser){
        return this.accountRepository.findById(idUser).getUsername();
    }
}
