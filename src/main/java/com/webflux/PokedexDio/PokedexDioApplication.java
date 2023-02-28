package com.webflux.PokedexDio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.webflux.PokedexDio.model.Pokemon;
import com.webflux.PokedexDio.repository.PokemonRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexDioApplication.class, args);
	}
	@Bean
	CommandLineRunner init (PokemonRepository repository) {
		return args -> {
			Flux<Pokemon> pokemonFlux = Flux.just(
				new Pokemon(null, "Blastoise", "Water", "Torrent", 9.9),
				new Pokemon(null, "Caterpie", "Grass", "Dust of Darkness", 1.8),
				new Pokemon(null, "Bulbassaur","Grass","Solar Bean",5.5))
				.flatMap(repository::save);

			pokemonFlux
				.thenMany(repository.findAll())
				.subscribe(System.out::println);
		};
	}
}
