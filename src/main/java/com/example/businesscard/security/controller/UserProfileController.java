package com.example.businesscard.security.controller;

import com.example.businesscard.security.entity.UserProfile;
import com.example.businesscard.security.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getProfileByUserId(@PathVariable UUID userId) {
        Optional<UserProfile> userProfile = userProfileService.getProfileByUserId(userId);
        return userProfile.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create-or-update")
    public ResponseEntity<UserProfile> createOrUpdateProfile(@RequestBody UserProfile userProfile) {
        UserProfile savedProfile = userProfileService.createOrUpdateProfile(userProfile);
        return ResponseEntity.ok(savedProfile);
    }
}
