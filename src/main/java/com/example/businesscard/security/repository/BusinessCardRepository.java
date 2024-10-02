package com.example.businesscard.security.repository;

import com.example.businesscard.security.entity.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BusinessCardRepository extends JpaRepository<BusinessCard, UUID> {
    List<BusinessCard> findByUserId(UUID userId);

    List<BusinessCard> findByHashtagsContaining(String hashtag);

    List<BusinessCard> findByProfessionContainingIgnoreCase(String profession);
}
