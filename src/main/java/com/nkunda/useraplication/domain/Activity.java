package com.nkunda.useraplication.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private ActivityType nameOfActivity;
    private String address;
    private double amount;
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "userId")
    private User user;
}
