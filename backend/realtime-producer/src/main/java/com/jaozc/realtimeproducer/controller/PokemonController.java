package com.jaozc.realtimeproducer.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaozc.realtimeproducer.model.Pokemon;
import com.jaozc.realtimeproducer.service.PokemonService;

@Validated
@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/id/{id}")
    public Pokemon getPokemonById(@PathVariable Long id){
            return pokemonService.getPokemonById(id);
    }

    @GetMapping("/name/{name}")
    public Pokemon getPokemonByName(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping("/number/{number}")
    public Pokemon getPokemonByNumber(@PathVariable int number) {
        return pokemonService.getPokemonByNumber(number);
    }

    @GetMapping("/random")
    public Pokemon getRandomPokemon() {
        return pokemonService.getRandomPokemon();
    }
    
}
