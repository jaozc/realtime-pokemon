package com.jaozc.realtimepokemon.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaozc.realtimepokemon.model.Pokemon;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomPokemonProducer {
    
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(Pokemon pokemon) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        String pokemonAsString = objectMapper.writeValueAsString(pokemon);
        log.info("Payload enviado: { " + pokemonAsString + "}");
        kafkaTemplate.send(topicName, pokemonAsString);
    }


}
