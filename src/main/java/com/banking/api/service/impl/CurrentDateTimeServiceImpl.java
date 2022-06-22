package com.banking.api.service.impl;

import com.banking.api.service.DateTimeService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class CurrentDateTimeServiceImpl implements DateTimeService {

    @Override
    public ZonedDateTime getCurrentDateTime() {
        return ZonedDateTime.now();
    }

}
