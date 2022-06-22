package com.banking.api.service.impl;

import com.banking.api.repository.UserRepository;
import com.banking.api.entity.User;
import com.banking.api.service.UserContextService;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpringSecurityUserContextServiceImpl implements UserContextService {

    private final UserRepository userRepository;

    public SpringSecurityUserContextServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getCurrentUser() {
        Optional<User> u = userRepository.findById(getCurrentUserId());
        if( !u.isPresent() ){
            throw new RuntimeException("Current user does not exist");
        }else{
            return u.get();
        }
    }

    @Override
    public Long getCurrentUserId() {
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if( !(p instanceof UserDetails) ){
            throw new RuntimeException("Current user does not exist");
        }else{
            UserDetails userDetails = (UserDetails)p;
            Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
            if( !user.isPresent() ){
                throw new UsernameNotFoundException(userDetails.getUsername());
            }
            return user.get().getId();
        }
    }

    @Override
    public String getCurrentUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if( username == null ){
            throw new RuntimeException("Current user does not exist");
        }else{
            return username;
        }
    }

}