package com.example.businesscard.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_profiles", schema = "public")
public class UserProfile {

    @Id
    @GeneratedValue(generator = "UUID")  // Specify the custom generator
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")  // Use UUID generator
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Ensure user_id cannot be null
    private User user;

    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    // Additional fields for the user profile (e.g., contact details, address)
}
