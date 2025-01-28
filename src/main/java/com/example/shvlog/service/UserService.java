package com.example.shvlog.service;

import com.example.shvlog.domain.User;
import com.example.shvlog.repository.UserRepository;
import com.example.shvlog.exception.UserNotFound;
import com.example.shvlog.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFound::new);

        return new UserResponse(user);
    }
}

