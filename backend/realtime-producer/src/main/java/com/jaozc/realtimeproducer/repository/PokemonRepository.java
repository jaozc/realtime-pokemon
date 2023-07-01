package com.jaozc.realtimeproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaozc.realtimeproducer.model.Pokemon;

// @Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

     Pokemon findByName(String name);

     Pokemon findByNumber(int number);
    
}
