package com.jaozc.realtimeproducer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.jaozc.realtimeproducer.model.Pokemon;
import com.jaozc.realtimeproducer.repository.PokemonRepository;

@EnableScheduling
@EnableKafka
@Configuration
@SpringBootApplication
public class RealtimeProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimeProducerApplication.class, args);
	}

	@Bean
    NewTopic createRandomPokemonTopic() {
    return TopicBuilder.name("random-pokemon")
      .partitions(1)
      .replicas(1)
      .build();
  	}

	@Bean
	CommandLineRunner initPokemonDatabase(PokemonRepository pokemonRepository, ResourceLoader resourceLoader) {

		return args -> {
			pokemonRepository.deleteAll();
			Scanner sc;
			
			// #,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary,Sprite
			Resource resource = resourceLoader.getResource("classpath:static/Pokemon.csv");
        	InputStream inputStream = resource.getInputStream();
        	sc = new Scanner(inputStream, "UTF-8");

			sc.useDelimiter(",");
			while (sc.hasNext()) {
				Pokemon pokemon = new Pokemon();
				pokemon.setNumber(Integer.parseInt(sc.next()));
				pokemon.setName(sc.next());
				List<String> types =  new ArrayList<>();
				types.add(sc.next());
				types.add(sc.next());
				pokemon.setTypes(types);
				pokemon.setTotal(Integer.parseInt(sc.next()));
				pokemon.setHealthPoints(Integer.parseInt(sc.next()));
				pokemon.setAttack(Integer.parseInt(sc.next()));
				pokemon.setDefense(Integer.parseInt(sc.next()));
				pokemon.setSpecialAttack(Integer.parseInt(sc.next()));
				pokemon.setSpecialDefence(Integer.parseInt(sc.next()));
				pokemon.setSpeed(Integer.parseInt(sc.next()));
				pokemon.setGeneration(Integer.parseInt(sc.next()));
				pokemon.setLegendary(sc.next().equals("True"));
				pokemon.setSprite(sc.next());
				pokemonRepository.save(pokemon);
			}
			sc.close();
		};
	}

}
