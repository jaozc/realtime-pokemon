package com.jaozc.realtimepokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaozc.realtimepokemon.model.Pokemon;

// @Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

     Pokemon findByName(String name);

     Pokemon findByNumber(int number);
    
}
