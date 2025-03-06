package org.codewithsteve.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Table(name = "profiles")
@Entity
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    @Column(name = "loyalty_points")
    private int loyalty_points;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;

}
