package com.banking.api.controller;

import com.banking.api.entity.Transaction;
import com.banking.api.exception.UserNotFoundException;
import com.banking.api.repository.UserRepository;
import com.banking.api.service.impl.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TransactionController {

    TransactionServiceImpl transactionService;
    UserRepository userRepository;



    @GetMapping("/history")
    public ResponseEntity<List<Transaction>> history(Principal principal){
        validateUser(principal);

        return new ResponseEntity<List<Transaction>>(transactionService.findAllByCreatedBy(principal.getName()),
                HttpStatus.OK);
    }
    private void validateUser(Principal principal){
        String username = principal.getName();
        this.userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UserNotFoundException(username)
                );
    }

}
