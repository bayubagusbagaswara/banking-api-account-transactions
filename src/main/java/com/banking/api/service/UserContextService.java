package com.banking.api.service;

import com.banking.api.entity.User;

public interface UserContextService {
    User getCurrentUser();
    Long getCurrentUserId();
    String getCurrentUsername();
}
