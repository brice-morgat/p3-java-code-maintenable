package com.openclassroom.chatop.models;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_email", columnNames = { "email" })
        }
)
public class User {
    @Id
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    @Column(nullable = false, length = 255)
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    @Builder.Default
    private Set<Rental> rentals = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private Set<Message> messages = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
