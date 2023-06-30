package com.jaozc.realtimepokemon;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.jaozc.realtimepokemon.model.Pokemon;
import com.jaozc.realtimepokemon.repository.PokemonRepository;

@EnableScheduling
@EnableKafka
@SpringBootApplication
public class RealtimePokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimePokemonApplication.class, args);
	}

	@Bean
	CommandLineRunner initPokemonDatabase(PokemonRepository pokemonRepository) {
		return args -> {
			pokemonRepository.deleteAll();
			Scanner sc;
			// #,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary,Sprite
			
			ClassLoader classLoader = getClass().getClassLoader();
        	URL resource = classLoader.getResource("static/Pokemon.csv");
        	if (resource == null) {
            	throw new IllegalArgumentException("file not found! " + "Pokemon.csv");
        	} else {
            	sc = new Scanner( new File(resource.toURI()));
        	}

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
