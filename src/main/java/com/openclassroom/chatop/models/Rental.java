package com.openclassroom.chatop.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Table(name = "rentals")
public class Rental {
    @Id
    private Long id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String name;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer surface;

    @NotNull
    @DecimalMin("0.0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false, length = 500)
    private String picture;

    @NotBlank
    @Lob
    @Column(nullable = false)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ToString.Exclude
    @OneToMany(mappedBy = "rental")
    @Builder.Default
    private Set<Message> messages = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}