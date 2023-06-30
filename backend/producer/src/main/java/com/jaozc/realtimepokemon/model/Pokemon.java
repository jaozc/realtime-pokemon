package com.jaozc.realtimepokemon.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private String name;
    private List<String> types;
    private String sprite;

    // Pokemon Status
    private int total;
    private int healthPoints;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefence;
    private int speed;
    private int generation;
    private boolean isLegendary;
    
}
