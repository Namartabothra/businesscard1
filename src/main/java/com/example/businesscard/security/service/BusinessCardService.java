package com.example.businesscard.security.service;

import com.example.businesscard.security.entity.BusinessCard;
import com.example.businesscard.security.repository.BusinessCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BusinessCardService {

    private final BusinessCardRepository businessCardRepository;

    public BusinessCard createBusinessCard(BusinessCard businessCard) {
        return businessCardRepository.save(businessCard);
    }

    public List<BusinessCard> getBusinessCardsByUserId(UUID userId) {
        return businessCardRepository.findByUserId(userId);
    }

    public List<BusinessCard> searchByHashtag(String hashtag) {
        return businessCardRepository.findByHashtagsContaining(hashtag);
    }

    public List<BusinessCard> searchByProfession(String profession) {
        return businessCardRepository.findByProfessionContainingIgnoreCase(profession);
    }
}
