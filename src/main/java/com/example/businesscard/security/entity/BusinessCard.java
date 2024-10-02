package com.example.businesscard.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "business_cards")
public class BusinessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "profession", nullable = false)
    private String profession;

    @Column(name = "hashtags")
    private String hashtags;  // store hashtags like #baker, #plumber

    @Column(name = "description", length = 500)
    private String description;  // Description of the user's business

    @Column(name = "portfolio_url")
    private String portfolioUrl;  // Optional link to an external portfolio

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;
}
