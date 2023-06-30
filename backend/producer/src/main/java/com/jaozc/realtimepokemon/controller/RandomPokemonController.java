package com.jaozc.realtimepokemon.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaozc.realtimepokemon.service.PokemonService;
import com.jaozc.realtimepokemon.service.RandomPokemonProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class RandomPokemonController {
    
    private final RandomPokemonProducer randomPokemonProducer;
    private final PokemonService pokemonService;

    @Scheduled(fixedRate = 1000)
    @GetMapping(value = "/send")
    public void sendRandomPokemon() throws JsonProcessingException {
        randomPokemonProducer.send(pokemonService.getRandomPokemon());
    }
}
