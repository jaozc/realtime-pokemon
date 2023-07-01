package com.jaozc.realtimeproducer.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.jaozc.realtimeproducer.model.Pokemon;
import com.jaozc.realtimeproducer.repository.PokemonRepository;

@Service
public class PokemonService {
    
    PokemonRepository pokemonRepository;
    Random rand;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
        this.rand = new Random();
    }

    public Pokemon getPokemonById(Long id){
        return pokemonRepository.findById(id).orElseThrow(() -> new Error("Pokemon not found!"));
    }

    public Pokemon getPokemonByName(String name){
        return pokemonRepository.findByName(name);
    }

    public Pokemon getPokemonByNumber(int number) {
        return pokemonRepository.findByNumber(number);
    }

    public List<Pokemon> getAll(){
        return pokemonRepository.findAll();
    }

    public Pokemon getRandomPokemon() {
        
        int maxInt = 721;
        int randomNumber = 1 + rand.nextInt(maxInt);
        return pokemonRepository.findByNumber(randomNumber);
    }


}
