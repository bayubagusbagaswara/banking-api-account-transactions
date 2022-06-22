package com.banking.api.config;

import com.banking.api.service.DateTimeService;
import com.banking.api.service.UserContextService;
import com.banking.api.repository.UserRepository;
import com.banking.api.service.impl.CurrentDateTimeServiceImpl;
import com.banking.api.service.impl.SpringSecurityUserContextServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "userContextProvider", dateTimeProviderRef = "dateTimeProvider")
public class TransactionConfig {

    @Bean
    UserContextService userContextService(UserRepository userRepository){
        return new SpringSecurityUserContextServiceImpl(userRepository);
    }


    @Bean
    DateTimeService dateTimeService(){
        return new CurrentDateTimeServiceImpl();
    }

    @Bean
    DateTimeProvider dateTimeProvider(DateTimeService dateTimeService){
        return () -> Optional.of(dateTimeService.getCurrentDateTime());
    }

    @Bean
    AuditorAware<String> userContextProvider(UserContextService userContextService){
        return () -> Optional.of(userContextService.getCurrentUsername());
    }
}


