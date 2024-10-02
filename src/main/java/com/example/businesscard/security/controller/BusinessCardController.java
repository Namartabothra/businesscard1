package com.example.businesscard.security.controller;

import com.example.businesscard.security.entity.BusinessCard;
import com.example.businesscard.security.service.BusinessCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/business-cards")
@RequiredArgsConstructor
public class BusinessCardController {

    private final BusinessCardService businessCardService;

    @PostMapping("/create")
    public ResponseEntity<BusinessCard> createBusinessCard(@RequestBody BusinessCard businessCard) {
        BusinessCard createdCard = businessCardService.createBusinessCard(businessCard);
        return ResponseEntity.ok(createdCard);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BusinessCard>> getBusinessCardsByUser(@PathVariable UUID userId) {
        List<BusinessCard> businessCards = businessCardService.getBusinessCardsByUserId(userId);
        return ResponseEntity.ok(businessCards);
    }

    @GetMapping("/search/hashtag")
    public ResponseEntity<List<BusinessCard>> searchByHashtag(@RequestParam String hashtag) {
        List<BusinessCard> cards = businessCardService.searchByHashtag(hashtag);
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/search/profession")
    public ResponseEntity<List<BusinessCard>> searchByProfession(@RequestParam String profession) {
        List<BusinessCard> cards = businessCardService.searchByProfession(profession);
        return ResponseEntity.ok(cards);
    }
}
