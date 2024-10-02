package com.example.businesscard.security.service;

import com.example.businesscard.security.entity.UserProfile;
import com.example.businesscard.security.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public Optional<UserProfile> getProfileByUserId(UUID userId) {
        return userProfileRepository.findByUserId(userId);
    }

    public UserProfile createOrUpdateProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
